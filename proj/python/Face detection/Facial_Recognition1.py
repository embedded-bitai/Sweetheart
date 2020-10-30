import cv2
import numpy as np
from flask import Flask
from flask_restful import Api
from flask_cors import CORS
import os
from os import listdir
from os.path import isfile, join
import shutil

#얼굴 저장 함수
face_dirs = 'faces/'
face_classifier = cv2.CascadeClassifier('haarcascade_frontalface_default.xml')

#얼굴 검출 함수
def face_extractor(img):
    gray = cv2.cvtColor(img,cv2.COLOR_BGR2GRAY)
    faces = face_classifier.detectMultiScale(gray,1.3,5)
    #얼굴이 없으면 패스!
    if faces is ():
        return None
    # 얼굴이 있으면 얼굴 부위만 이미지로 만든다
    for(x, y, w, h) in faces:
        cropped_face = img[y:y+h, x:x+w]

    return cropped_face

# 카메라 ON
def face_detection():
    print('face_detection()')
    cam = cv2.VideoCapture(0)
    count = 0
    fps = 30
    delay = int(1000 / fps)

    while cam.isOpened():
        # 카메라로 부터 사진 한장 읽어 오기
        ret, frame = cam.read()
        # 얼굴 감지 하여 얼굴만 가져오기
        if face_extractor(frame) is not None:
            count += 1
            # 얼굴 이미지 크기르 200 x 200으로 조정
            face = cv2.resize(face_extractor(frame), (200, 200))
            # 조정된 이미지를 흑백으로 변환
            face = cv2.cvtColor(face, cv2.COLOR_BGR2GRAY)
            # faces폴더에 jpg파일로 저장
            file_name_path = 'faces/user' + str(count) + '.jpg'
            cv2.imwrite(file_name_path, face)
            # 화면에 얼굴과 현재 저장 개수 표시
            cv2.putText(face, str(count), (50, 50), cv2.FONT_HERSHEY_COMPLEX, 1, (0, 255, 0), 2)
            cv2.imshow('Face Cropper', face)
        else:
            print("Face not Found")
            pass

        if count == 100:
            break

        if cv2.waitKey(delay) & 0xFF == ord('q'):
            break

    cam.release()
    cv2.destroyAllWindows()
    print('Colleting Samples Complete!!!')

    return 'register'

def face_learning():
    print('face_learning()')
    data_path = 'faces/'
    # faces폴데 있는 파일 리스트 얻기
    onlyfiles = [f for f in listdir(data_path) if isfile(join(data_path, f))]
    # 데이터와 매칭될 라벨 변수
    Training_Data, Labels = [], []
    # 파일 개수 만큼 루프
    for i, files in enumerate(onlyfiles):
        image_path = data_path + onlyfiles[i]
        # 이미지 불러오기
        images = cv2.imread(image_path, cv2.IMREAD_GRAYSCALE)
        # 이미지 파일이 아니거나 못 읽어 왔다면 무시
        Training_Data.append(np.asarray(images, dtype=np.uint8))
        # Labels 리스트엔 카운트 번호 추가
        Labels.append(i)

    # Labels를 32비트 정수로 변환
    Labels = np.asarray(Labels, dtype=np.int32)
    # 모델 생성
    model = cv2.face.LBPHFaceRecognizer_create()
    # 학습 시작
    model.train(np.asarray(Training_Data), np.asarray(Labels))

    print("Model Training Complete!!!!!")

    return "learning"

def face_detector(img):
    gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    faces = face_classifier.detectMultiScale(gray, 1.3, 5)

    if faces is ():
        return img, []

    for (x, y, w, h) in faces:
        cv2.rectangle(img, (x, y),
                      (x + w, y + h), (0, 255, 255), 2)
        roi = img[y:y + h, x:x + w]
        roi = cv2.resize(roi, (200, 200))

    return img, roi

def face_login():
    print('face_login()')
    data_path = 'faces/'
    onlyfiles = [f for f in listdir(data_path) if isfile(join(data_path, f))]

    Training_Data, Labels = [], []

    for i, files in enumerate(onlyfiles):
        image_path = data_path + onlyfiles[i]
        images = cv2.imread(image_path, cv2.IMREAD_GRAYSCALE)
        Training_Data.append(np.asarray(images, dtype=np.uint8))
        Labels.append(i)

    Labels = np.asarray(Labels, dtype=np.int32)
    model = cv2.face.LBPHFaceRecognizer_create()
    model.train(np.asarray(Training_Data), np.asarray(Labels))

    fps = 30
    delay = int(1000 / fps)

    # 카메라 열기
    cam = cv2.VideoCapture(0)
    while cam.isOpened():
        # 카메라로 부터 사진 한장 읽기
        ret, frame = cam.read()
        final_frame = frame
        # 얼굴 검출 시도
        image, face = face_detector(final_frame)

        try:
            # 검출된 사진을 흑백으로 변환
            face = cv2.cvtColor(face, cv2.COLOR_BGR2GRAY)
            # 위에서 학습된 모델로 예측시도
            result = model.predict(face)
            # result[1]은 신뢰도이고 0에 가까울수록 동일인물이라는 뜻
            if result[1] < 500:
                confidence = int(100 * (1 - (result[1]) / 300))
                # 유사도 화면에 표시
                display_string = str(confidence) + '% Confidence it is user'
                cv2.putText(image, display_string, (100, 120), cv2.FONT_HERSHEY_COMPLEX, 1, (250, 120, 255), 2)

            # 80 이상이면 동일 인물(수정가능)
            if confidence > 80:
                cv2.putText(image, "Unlocked", (250, 450), cv2.FONT_HERSHEY_COMPLEX, 1, (0, 255, 0), 2)
                cv2.imshow('Face Login', image)
                break
            else:
                # 80 이하면 locked
                cv2.putText(image, "Locked", (250, 450), cv2.FONT_HERSHEY_COMPLEX, 1, (0, 0, 255), 2)
                cv2.imshow('Face Login', image)

        except:
            # 얼굴 검출 안됨
            cv2.putText(image, "Face Not Found", (250, 450), cv2.FONT_HERSHEY_COMPLEX, 1, (255, 0, 0), 2)
            cv2.imshow('Face Login', image)
            pass

        # 키보드 입력 대기 함수, 입력 값이 엔터일 경우 종료
        if cv2.waitKey(delay) & 0xFF == ord('q'):
            break

    # 오픈한 캡쳐 객체 해제
    cam.release()
    # 화면에 나타는 윈도우 종료
    cv2.destroyAllWindows()
    print('Face Login Success!!!!')

    return "Success"


app = Flask(__name__)
api = Api(app)
CORS(app, resources={r'/*': {'origins': '*'}})

@app.route('/faceDetection', methods=['POST'])
def on_face_register():
    os.makedirs('faces', exist_ok=True)
    print('face_register()')
    registerResult = face_detection()
    print('face register return(): ' + registerResult)

    return registerResult

@app.route('/faceLearning', methods=['POST'])
def on_face_learning():
    print('on_face_learning()')
    learningResult = face_learning()
    print('face learning return(): ' + learningResult)

    return learningResult

@app.route('/faceLogin', methods=['GET'])
def on_face_login():
    print('on_face_login()')
    loginResult = face_login()
    print('face_login() return: ' + loginResult)

    return loginResult

@app.route('/rmFaceDir', methods=['POST'])
def on_rm_face_img():
    print('rm_face_img()')
    shutil.rmtree('faces')

    return 'remove faces directory'

if __name__ == '__main__':
    app.run(host='localhost', port=os.getenv('FLASK_RUN_PORT'), debug=os.getenv('FLASK_DEBUG'))