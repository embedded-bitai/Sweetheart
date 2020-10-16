<template>
  <div id="app">
    <div class="container" :class="{'sign-up-active' : signUp}">
      <div class="overlay-container">
        <div class="overlay">
          <div class="overlay-left">
            <h2 class="left_text">Welcome Back!</h2>
            <p class="left_text">Please login with your personal info</p>
            <div>
              <button class="invert" id="signIn" @click="signUp = !signUp">로그인</button>
            </div>
          </div>
          <div class="overlay-right">
            <h2>Logins Recent</h2>
            <v-avatar size="200" style="background-color: #1e1e1e;">
              <img
                src="https://cdn.vuetifyjs.com/images/john.jpg"
                alt="John"
                style="padding: 5%"
              >
            </v-avatar>
          </div>
        </div>
      </div>
      <form class="sign-up" action="#">
        <div class="ma-5">
          <h2>Create login</h2>
        </div>
        <div>Use your email for registration</div>
        <div>
          <div style="float: left">
            <input type="text" placeholder="Name" v-model="name"/>
          </div>
          <div style="float: right">
            <input type="NickName" placeholder="NickName" v-model="nickname"/>
          </div>
        </div>
        <div style="width: 75%">
          <input type="email" placeholder="Email" v-model="userId" />
        </div>
        <div style="width: 75%">
          <input type="password" placeholder="Password" v-model="pw" />
        </div>
        <div style="width: 75%">
          <input type="password" placeholder="PasswordCheck" v-model="pw" />
        </div>
        <div>
          <div style="float: left">
            <input type="birth" placeholder="Birth" v-model="birth" />
          </div>
          <div style="float: right">
            <input type="gender" placeholder="sex" v-model="gender" />
          </div>
        </div>
        <div style="width: 75%">
          <input type="phone" placeholder="Phone" v-model="phone" />
        </div>
        <div style="width: 75%">
          <input type="address" placeholder="Address" v-model="address" />
        </div>
        <div>
          <div style="float: left">
            <v-checkbox
              v-model="faceDetectionCheck"
              label="얼굴 인식 체크 동의 박스"
            ></v-checkbox>
          </div>
          <v-dialog
            v-model="dialog"
            width="500"
          >
            <template v-slot:activator="{ on, attrs }">
              <v-btn
                color="red lighten-2"
                dark
                v-bind="attrs"
                v-on="on"
              >
                Click Me
              </v-btn>
            </template>

            <v-card>
              <v-card-title class="headline grey lighten-2">
                Privacy Policy
              </v-card-title>

              <v-card-text>
                Lorem
              </v-card-text>

              <v-divider></v-divider>

              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn
                  color="primary"
                  text
                  @click="dialog = false"
                >
                  I accept
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
        </div>
        <div>
          <v-btn @click="registerAccount">회원가입</v-btn>
        </div>
      </form>
      <form class="sign-in" action="#">
        <h2>로그인</h2>
        <div>Use your account</div>
        <input type="email" placeholder="Email" />
        <input type="password" placeholder="Password" />
        <a href="Test">Forgot your password?</a>
        <button>로그인</button>
        <button>얼굴인식</button>
        <button @click="signUp = !signUp">회원가입</button>
      </form>
    </div>
  </div>
</template>

<script>
import Vue from 'vue'
import VueTelInput from 'vue-tel-input'
import VueDaumPostcode from 'vue-daum-postcode'
import axios from 'axios'

Vue.use(VueDaumPostcode)
Vue.use(VueTelInput)
export default {
  name: 'FirstPage',
  data () {
    return {
      signUp: false,
      name: null,
      nickname: null,
      userId: null,
      pw: null,
      birth: null,
      gender: null,
      phone: null,
      address: null,
      faceDetectionCheck: '',
      dialog: true
    }
  },
  methods: {
    registerAccount () {
      console.log('name: ' + this.name + ', ' + this.nickname + ', ' + this.userId + ', ' + this.pw + ', ' + this.birth + ', ' + this.gender + ', ' + this.phone + ', ' + this.address)
      const { name, nickname, userId, pw, birth, gender, phone, address } = this
      axios.post('http://localhost:7777/users/setup',
        { name, nickname, userId, pw, birth, gender, phone, address })
        .then(res => {
          console.log('success register')
        })
        .catch(err => {
          console.log(err.toString())
        })
    }
  }
}
</script>

<style scoped lang="scss">
#app {
  font-family: Tahoma;
  font-size: 1rem;
  color: #222;
  background: linear-gradient(#070926, #5761c2);
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
}

.container {
  position: relative;
  width: 95%;
  height: 90%;
  border-radius: 10px;
  overflow: hidden;
  box-shadow: 0 15px 30px rgba(0, 0, 0, .2),
  0 10px 10px rgba(0, 0, 0, .2);
  background: linear-gradient(to bottom, #efefef, #ccc);

  .overlay-container {
    position: absolute;
    top: 0;
    left: 40%;
    width: 60%;
    height: 100%;
    overflow: hidden;
    transition: transform .5s ease-in-out;
    z-index: 100;
  }

  .overlay {
    position: relative;
    left: -100%;
    height: 100%;
    width: 200%;
    background: linear-gradient(to bottom right, #1e1e1e, #1e1e1e);
    color: #fff;
    transform: translateX(0);
    transition: transform .5s ease-in-out;
  }

  @mixin overlays($property) {
    position: absolute;
    top: 0;
    display: flex;
    align-items: center;
    justify-content: space-around;
    flex-direction: column;
    padding: 70px 40px;
    width: calc(50%);
    height: calc(100%);
    text-align: center;
    transform: translateX($property);
    transition: transform .5s ease-in-out;
  }

  .overlay-left {
    @include overlays(-20%);

    .left_text {
      margin-left: 35%;
    }
  }

  .overlay-right {
    @include overlays(0);
    right: 0;
  }
}

h2 {
  margin: 0;
}

p {
  margin: 20px 0 30px;
}

a {
  color: #222;
  text-decoration: none;
  margin: 15px 0;
  font-size: 1rem;
}

button {
  border-radius: 10px;
  border: 1px solid #1e1e1e;
  background-color: #1e1e1e;
  color: #fff;
  font-size: 1rem;
  font-weight: bold;
  padding: 10px 40px;
  letter-spacing: 1px;
  text-transform: uppercase;
  cursor: pointer;
  width: 80%;
  transition: transform .1s ease-in;

  &:active {
    transform: scale(.9);
  }

  &:focus {
    outline: none;
  }
}

button.invert {
  background-color: transparent;
  border-color: #fff;
  margin-left: 35%;
}

div {
  button {
    width: 100%;
  }
}

form {
  position: absolute;
  top: 0;
  display: flex;
  align-items: center;
  justify-content: space-around;
  flex-direction: column;
  padding: 90px 60px;
  width: calc(50% - 120px);
  height: calc(100% - 180px);
  text-align: center;
  background: linear-gradient(to bottom, #efefef, #ccc);
  transition: all .5s ease-in-out;

  div {
    font-size: 1rem;
    margin: 2px;
  }

  input {
    background-color: #eee;
    border: none;
    padding: 8px 15px;
    margin: 6px 0;
    width: calc(100% - 30px);
    border-radius: 15px;
    border-bottom: 1px solid #ddd;
    box-shadow: inset 0 1px 2px rgba(0, 0, 0, .4),
    0 -1px 1px #fff,
    0 1px 0 #fff;
    overflow: hidden;

    &:focus {
      outline: none;
      background-color: #fff;
    }
  }
}

.sign-in {
  width: 40%;
  height: 100%;
  left: 0;
  z-index: 2;
}

.sign-up {
  width: 60%;
  height: 100%;
  left: -20%;
  z-index: 1;
  opacity: 0;
}

.sign-up-active {
  .sign-in {
    transform: translateX(100%);
  }

  .sign-up {
    transform: translateX(100%);
    opacity: 1;
    z-index: 5;
    animation: show .5s;
  }

  .overlay-container {
    transform: translateX(-100%);
  }

  .overlay {
    transform: translateX(50%);
  }

  .overlay-left {
    transform: translateX(0);
  }

  .overlay-right {
    transform: translateX(20%);
  }
}
</style>
