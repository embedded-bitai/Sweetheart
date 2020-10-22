<template>
  <v-app class="fill-height">
    <v-main class="fill-height" id="background">
      <v-container class="fill-height" fluid>
        <v-row class="fill-height" align="center" justify="center">
          <v-col class="fill-height" cols="12" sm="8" md="10">
            <v-card shaped class="elevation-12 fill-height">
              <v-window v-model="step" class="fill-height">
                <v-window-item :value="1" class="fill-height">
                  <v-row class="fill-height">
                    <v-col id="firstLeft" cols="12" md="4">
                      <FirstLeft
                        @increaseStep="increaseStep"
                        @signIn="onSignIn"
                      >
                      </FirstLeft>
                    </v-col>
                    <v-col id="firstRight" cols="12" md="8">
                      <FirstRight></FirstRight>
                    </v-col>
                  </v-row>
                </v-window-item>
                <v-window-item :value="2" class="fill-height">
                  <v-row class="fill-height">
                    <v-col id="secondLeft" cols="12" md="4" class="teal accent-3">
                      <second-left @decreaseStep="decreaseStep"></second-left>
                    </v-col>
                    <v-col id="secondRight" cols="12" md="8">
                      <SecondRight
                        @idCheck="onCheckId"
                        :id-validate="idValidate"
                        :faceRegister="faceRegister"
                        @signUp="onSignUp"
                      ></SecondRight>
                    </v-col>
                  </v-row>
                </v-window-item>
              </v-window>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
// @ is an alias to /src
import FirstLeft from '@/components/FirstLayout/FirstLeft'
import FirstRight from '@/components/FirstLayout/FirstRight'
import SecondLeft from '@/components/FirstLayout/SecondLeft'
import SecondRight from '@/components/FirstLayout/SecondRight'
import axios from 'axios'
import { mapActions } from 'vuex'

export default {
  name: 'Home',
  components: {
    SecondRight,
    SecondLeft,
    FirstRight,
    FirstLeft
  },
  data () {
    return {
      step: 1,
      idValidate: false,
      faceRegister: false
    }
  },
  methods: {
    increaseStep () {
      this.step++
    },
    decreaseStep () {
      this.step--
    },
    onCheckId (payload) {
      console.log('payload: ' + payload.userId)
      const { userId } = payload
      axios.post('http://localhost:7777/users/checkId',
        { userId })
        .then(res => {
          alert('사용가능한 ID 입니다.')
          this.idValidate = true
        })
        .catch(err => {
          console.log(err.response.data)
          alert('이미 존재하는 아이디입니다.')
          this.idValidate = false
        })
    },
    onSignUp (payload) {
      console.log('payload: ' + payload)
      const { userName, userNickname, userId, userPassword, date, userGender, userEmail, totalAddress } = payload
      axios.post('http://localhost:7777/users/',
        { userName, userNickname, userId, userPassword, date, userGender, userEmail, totalAddress })
        .then(res => {
          alert('회원가입 성공')
          this.step--
        })
        .catch(err => {
          console.log(err.response.data)
        })
    },
    onSignIn (payload) {
      console.log('Login on-sign-in() - ' + payload.userId)
      this.login(payload).then(res => {
        console.log('onSignIn() res: ' + res)
        this.$router.push({ name: 'ScrollTestPage' })
      }).catch(err => {
        console.log(err)
        alert('가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.')
      })
    },
    ...mapActions(['login'])
  }
}
</script>

<style lang="scss">
#background {
  background: linear-gradient(#0d165a, #020423);
}
#firstLeft {
  background: linear-gradient(#020423, #0d165a);
}
#firstRight {
  background: #0c166c;
}
#secondLeft {
  background: linear-gradient(#020423, #0d165a);
}
#secondRight {
  background: #0c166c;
}
</style>
