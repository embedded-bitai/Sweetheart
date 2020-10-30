<template>
  <div>
    <v-card-text class="white--text mt-12">
      <h1 class="text-center display-1">Welcome Back !</h1>
      <h5 class="text-center">To Keep connected with us please login with your personnel info</h5>
    </v-card-text>
    <div class="text-center">
      <v-btn rounded outlined dark @click="decreaseStep">SIGN IN</v-btn>
    </div>
  </div>
</template>

<script>
export default {
  name: 'SecondLeft',
  methods: {
    decreaseStep () {
      this.$emit('decreaseStep', null)
    }
  }
}
</script>
<style>

</style>
