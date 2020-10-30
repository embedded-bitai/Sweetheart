<template>
  <div class="fistLeftSideMenu">
      <v-layout column>
        <v-flex>
          <v-btn
            depressed
            style="background-color: rgba(255,255,255,0.0); color: white; margin-bottom: 10px; font-size: 20px"
            @click="gotoMyFeed"
          >
            <v-img
              v-if="userImg"
              src="https://cdn.vuetifyjs.com/images/john.jpg"
              width="25px"
            ></v-img>
            <v-img
              v-else
              :src=this.userDefaultImg
              width="25px"
            ></v-img>
            <span>{{ userName }}</span>
          </v-btn>
        </v-flex>
        <v-flex>
          <v-btn
            @click.stop="drawer = !drawer"
            depressed
            style="background-color: rgba(255,255,255,0.0); color: white; margin-bottom: 10px; font-size: 20px">
            <v-icon>mdi-account-multiple</v-icon>
            <span>Friends</span>
          </v-btn>
          <v-navigation-drawer
            width="250"
            v-model="drawer"
            absolute
            bottom
            temporary
            hide-overlay
          >
            <v-layout column>
              <v-flex>
              <v-text-field></v-text-field>
              </v-flex>
              <v-flex>
                <v-list
                  nav
                  dense
                >
                  <v-list-item-group
                    v-model="group"
                    active-class="deep-purple--text text--accent-4"
                  >
                    <v-list-item>
                      <v-list-item-title>민호</v-list-item-title>
                    </v-list-item>
                  </v-list-item-group>
                </v-list>
              </v-flex>
            </v-layout>
          </v-navigation-drawer>
        </v-flex>
        <v-flex>
          <v-btn depressed style="background-color: rgba(255,255,255,0.0); color: white; margin-bottom: 10px; font-size: 20px">
            <v-icon>mdi-chat</v-icon>
            <span>chat</span>
          </v-btn>
        </v-flex>
        <v-flex>
          <v-btn depressed style="background-color: rgba(255,255,255,0.0); color: white; margin-bottom: 10px; font-size: 20px">
            <v-icon>mdi-video</v-icon>
            <span>Video</span>
          </v-btn>
        </v-flex>
        <v-divider></v-divider>
      </v-layout>
    </div>
</template>

<script>
export default {
  data () {
    return {
      drawer: false,
      group: null,
      userName: this.$store.state.myProfile[0].userName,
      userImg: '',
      userDefaultImg: require('../../assets/blank-profile-picture-973460_1280.png')
    }
  },
  watch: {
    group () {
      this.drawer = false
    }
  },
  methods: {
    gotoMyFeed () {
      console.log('gotoMyFeed()')
    }
  }
}
</script>

<style src="@/assets/firstLayout.css" scoped/>
