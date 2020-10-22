<template>
  <v-app-bar
    app
    dark
    height="230"
  >
    <v-row>
      <v-col cols="12" md="2">
        <v-avatar size="100px" class="ml-10">
          <img
            src="https://cdn.vuetifyjs.com/images/john.jpg"
            alt="John"
          >
        </v-avatar>
        <h3 class="text-center white--text"></h3>
        <div class="text-center white--text">
          <h4 class="green--text">role</h4>
        </div>
      </v-col>
      <v-spacer></v-spacer>
      <v-col cols="12" md="1">
        <v-btn
          class="green"
          rounded
          @click="onClickLogout"
        >
          Logout
        </v-btn>
      </v-col>
    </v-row>
  </v-app-bar>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'Gnb',
  data () {
    return {
      mini: true,
      leftMenu: true,
      rightMenu: false
    }
  },
  methods: {
    ...mapActions(['logout']),
    onClickLogout () {
      this.logout()
      alert('Success Logout')
      this.$router.push({ name: 'Home' })
    }
  }
}
</script>
