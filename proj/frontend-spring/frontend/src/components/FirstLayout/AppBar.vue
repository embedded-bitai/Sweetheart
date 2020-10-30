<template>
  <div class="appBar">
    <v-app-bar
      dense
      dark
      app
    >
      <v-btn
        fab
        small
        color="primary"
        depressed
        style="background-color: cornflowerblue"
      >
        로고<br>
        자리
      </v-btn>
      <v-spacer/>
      <div class="appBarMidIcon" style="margin: 30px">
        <v-btn icon style="margin: 35px" @click="goToHome">
          <v-icon>mdi-home</v-icon>
        </v-btn>
        <v-btn icon style="margin: 35px">
          <v-icon>mdi-account-multiple</v-icon>
        </v-btn>
        <v-btn icon style="margin: 35px">
          <v-icon>mdi-youtube</v-icon>
        </v-btn>
      </div>

      <v-spacer/>
      <div class="appBarRightIcon">
        <v-btn depressed @click="gotoMyFeed">
          <span>{{ userName }}</span>
        </v-btn>
        <v-btn icon>
          <v-icon>mdi-android-messages</v-icon>
        </v-btn>
        <v-btn icon>
          <v-icon>mdi-bell</v-icon>
        </v-btn>
        <v-menu
          v-model="menu"
          :close-on-content-click="false"
          nudge-left="300"
          offset-y

        >
          <template v-slot:activator="{ on, attrs }">
            <v-btn
              fab
              small
              depressed
              dark
              v-bind="attrs"
              v-on="on"
            >
              <v-icon icon>mdi-chevron-down</v-icon>
            </v-btn>
          </template>

          <v-card
            width="400"
          >
            <v-list>
              <v-list-item>
                <v-list-item-avatar>
                  <img
                    src="https://cdn.vuetifyjs.com/images/john.jpg"
                    alt="John"
                  >
                </v-list-item-avatar>

                <v-list-item-content>
                  <v-list-item-title>{{ userName }}</v-list-item-title>
                  <v-list-item-subtitle>so Good</v-list-item-subtitle>
                </v-list-item-content>

                <v-spacer/>
                <v-btn depressed @click="onLogOut()">
                  <v-icon>mdi-logout-variant</v-icon><span>LOGOUT</span>
                </v-btn>
              </v-list-item>
            </v-list>

            <v-divider/>

            <v-list>
              <v-list-item>
                <v-list-item-action>
                  <v-switch
                    color="purple"
                  ></v-switch>
                </v-list-item-action>
                <v-list-item-title><v-icon>mdi-android-messages</v-icon><span>MESSAGE</span></v-list-item-title>
              </v-list-item>

              <v-list-item>
                <v-list-item-action>
                  <v-switch
                    color="purple"
                  ></v-switch>
                </v-list-item-action>
                <v-list-item-title><v-icon>mdi-bell</v-icon><span>EEEE</span></v-list-item-title>
              </v-list-item>
            </v-list>

            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn
                text
                @click="this.menu = false"
              >
                Cancel
              </v-btn>
              <v-btn
                color="primary"
                text
                @click="this.menu = false"
              >
                Save
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-menu>
      </div>
    </v-app-bar>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
export default {
  data () {
    return {
      fav: true,
      menu: false,
      message: true,
      hints: true,
      userName: this.$store.state.myProfile[0].userName
    }
  },
  methods: {
    ...mapActions(['logout']),
    onLogOut () {
      console.log('on Log Out')
      this.logout()
      alert('Success Logout')
      this.$router.push({ name: 'Home' })
    },
    goToHome () {
      console.log('goToHome')
      this.$router.push({ name: 'MainDashBoard' })
    },
    gotoMyFeed () {
      console.log('gotoMyFeed')
    }
  }
}
</script>

<style src="@/assets/firstLayout.css" scoped/>
