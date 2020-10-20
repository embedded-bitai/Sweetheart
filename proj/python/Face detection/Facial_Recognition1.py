import cv2
import numpy as np
from os import makedirs
from os.path import isdir
from flask import Flask, jsonify
from flask_restful import Resource, Api, reqparse
from flask_cors import CORS
import os

#얼굴 저장 함수
face_dirs = 'faces/'

face_classifier = cv2.CascadeClassifier('haarcascade_frontalface_default.xml')

#얼굴 검출 함수
def face_extractor(img):
    gray = cv2.cvtColor(img,cv2.COLOR_BGR2GRAY)
    faces = face_classifier.detectMultiScale(gray,1.3,5)
    #얼굴이 없으면 패스!
    if faces is():
        return None
    # 얼굴이 있으면 얼굴 부위만 이미지로 만든다
    for(x,y,w,h) in faces:
        cropped_face = img[y:y+h, x:x+w]

    return cropped_face
# 얼굴만 저장하는 함수
# def take_pictures(name):
#     if not isdir(face_dirs+name):
#         makedirs(face_dirs+name)

# 카메라 ON
cap = cv2.VideoCapture(0)
count = 0

while True:
    # 카메라로 부터 사진 한장 읽어 오기
    ret, frame = cap.read()
    # 얼굴 감지 하여 얼굴만 가져오기
    if face_extractor(frame) is not None:
        count+=1
        # 얼굴 이미지 크기르 200 x 200으로 조정
        face = cv2.resize(face_extractor(frame),(200,200))
        # 조정된 이미지를 흑백으로 변환
        face = cv2.cvtColor(face, cv2.COLOR_BGR2GRAY)
        # faces폴더에 jpg파일로 저장
        file_name_path = 'faces/user'+str(count)+'.jpg'
        cv2.imwrite(file_name_path,face)
        # 화면에 얼굴과 현재 저장 개수 표시
        cv2.putText(face,str(count),(50,50),cv2.FONT_HERSHEY_COMPLEX,1,(0,255,0),2)
        cv2.imshow('Face Cropper',face)
    else:
        print("Face not Found")
        pass

    if cv2.waitKey(1)==13 or count==100:
        break

cap.release()
cv2.destroyAllWindows()
print('Colleting Samples Complete!!!')


app = Flask(__name__)

CORS(app, resources={r'/*': {'origins': '*'}})

@app.route('/facedetection',methods=['GET'])
def new_data():
    data_list = get_saramin()
    return jsonify(data_list)

if __name__ == '__main__':
    app.run(host='localhost', port=os.getenv('FLASK_RUN_PORT'), debug=os.getenv('FLASK_DEBUG'))
