<template>
  <div>
    <v-card-text class="mt-6">
      <h2 class="text-left display-2 white--text text--accent-3 mb-5">Sweet Heart</h2>
      <h3 class="text-left display-1 white--text mlt-4">Login</h3>
      <v-form class="mt-15">
        <v-col>
          <v-text-field
            dark
            label="ID"
            name="email"
            prepend-icon="email"
            v-model="userId"
            :rules="[v => !!v || 'ID is required']"
          />
        </v-col>
        <v-col>
          <v-text-field
            dark
            id="password"
            label="Password"
            name="Password"
            prepend-icon="lock"
            v-model="userPassword"
            :rules="[v => !!v || 'Password is required']"
            type="password"
          />
          <v-dialog
            v-model="dialog"
            persistent
            max-width="290"
          >
            <template v-slot:activator="{ on, attrs }">
              <h5
                class="text-end white--text"
                v-bind="attrs"
                v-on="on"
              >
                아이디 찾기
              </h5>
            </template>
            <v-card>
              <v-card-title class="headline">
                아이디 찾기
              </v-card-title>
              <v-card-text>
                <v-text-field
                  label="이름을 입력하세요."
                  v-model="searchName"
                ></v-text-field>
                <v-text-field
                  label="이메일을 입력하세요."
                  v-model="searchEmail"
                ></v-text-field>
                <h1 class="white--text">{{ searchId }}</h1>
              </v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn
                  color="green darken-1"
                  text
                  @click="dialog = false"
                >
                  Close
                </v-btn>
                <v-btn
                  @click="findId"
                  color="green darken-1"
                  text
                >
                  아이디 찾기
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
        </v-col>
      </v-form>
      <v-dialog
        v-model="dialog"
        persistent
        max-width="450"
      >
        <template v-slot:activator="{ on, attrs }">
          <h3
            class="text-center white--text mt-3"
            v-bind="attrs"
            v-on="on"
          >
            Forget your Password?
          </h3>
        </template>
        <v-card>
          <v-card-title class="headline">
            비밀번호 찾기
          </v-card-title>
          <v-card-text>
            <v-text-field
              label="이름을 입력하세요."
              v-model="searchName"
            ></v-text-field>
            <v-text-field
              label="아이디를 입력하세요."
              v-model="searchEmail"
            ></v-text-field>
            <v-text-field
              label="이메일을 입력하세요."
              v-model="searchEmail"
            ></v-text-field>
            <h1 class="white--text">{{ searchId }}</h1>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
              color="green darken-1"
              text
              @click="dialog = false"
            >
              Close
            </v-btn>
            <v-btn
              @click="findId"
              color="green darken-1"
              text
            >
              비밀번호 찾기
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-card-text>
    <div class="text-center mt-10">
      <v-btn
        class="black--text"
        width="70%"
        rounded
        color="white accent-3"
        dark
        @click="signIn"
      >
        SIGN IN
      </v-btn>
    </div>
    <div class="text-center mt-3">
      <v-btn width="70%" rounded color="teal accent-3" dark @click="increaseStep">SIGN UP</v-btn>
    </div>

  </div>
</template>

<script>
export default {
  name: 'FirstLeft',
  props: {
    step: {
      type: Number,
      default: 1
    },
    searchId: {
      type: String,
      required: true
    }
  },
  data () {
    return {
      slide: false,
      userId: '',
      userPassword: '',
      dialog: false,
      searchName: null,
      searchEmail: null,
      foundId: null
    }
  },
  methods: {
    increaseStep () {
      this.$emit('increaseStep', null)
    },
    signIn () {
      console.log('Login sign-in()')
      const { userId, userPassword } = this
      this.$emit('signIn', { userId, userPassword })
    },
    findId () {
      console.log('find id() - searchName: ' + this.searchName + ', serachEmail: ' + this.searchEmail)
      const { searchName, searchEmail } = this
      this.$emit('findId', { searchName, searchEmail })
    }
  }
}
</script>
