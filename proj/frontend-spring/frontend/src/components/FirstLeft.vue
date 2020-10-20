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
        </v-col>
      </v-form>
      <h3 class="text-center white--text mt-3">Forget your Password?</h3>
    </v-card-text>
    <div class="text-center mt-10">
      <v-btn
        v-on="on"
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
<!--    <div class="text-center mt-10">-->
<!--      <v-dialog-->
<!--        v-model="slide"-->
<!--        width="500"-->
<!--      >-->
<!--        <template v-slot:activator="{ on, attrs }">-->
<!--          <v-btn-->
<!--            v-bind="attrs"-->
<!--            v-on="on"-->
<!--            class="black&#45;&#45;text"-->
<!--            width="70%"-->
<!--            rounded-->
<!--            color="white accent-3"-->
<!--            dark-->
<!--            @click="faceLogin"-->
<!--          >-->
<!--            SIGN IN-->
<!--          </v-btn>-->
<!--        </template>-->
<!--        <v-card>-->
<!--          <v-card-title class="headline grey lighten-2">-->
<!--            얼굴인식-->
<!--          </v-card-title>-->
<!--          <v-card-text>-->
<!--            얼굴인식-->
<!--          </v-card-text>-->
<!--          <v-divider></v-divider>-->
<!--          <v-card-actions>-->
<!--            <v-spacer></v-spacer>-->
<!--            <v-btn-->
<!--              color="primary"-->
<!--              text-->
<!--              @click="slide = false"-->
<!--            >-->
<!--              Finish-->
<!--            </v-btn>-->
<!--            <v-btn-->
<!--              color="primary"-->
<!--              text-->
<!--              @click="signIn"-->
<!--            >-->
<!--              login-->
<!--            </v-btn>-->
<!--          </v-card-actions>-->
<!--        </v-card>-->
<!--      </v-dialog>-->
<!--    </div>-->
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
    }
  },
  data () {
    return {
      slide: false,
      userId: '',
      userPassword: ''
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
    faceLogin () {
      console.log('face login')
      this.$emit('faceLogin', null)
    }
  }
}
</script>
