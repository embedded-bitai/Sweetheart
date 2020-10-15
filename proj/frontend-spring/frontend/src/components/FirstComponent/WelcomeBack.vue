<template>
  <v-app>
    <h2 class="left_text">Welcome Back!</h2>
    <p class="left_text">Please login with your personal info</p>
    <v-btn class="invert" id="signIn" @click="signUp = !signUp">로그인</v-btn>
  </v-app>
</template>

<script>
export default {
  name: 'WelcomeBack',
  props: {
    signUp: {
      type: Boolean,
      require: true
    }
  }
}
</script>
