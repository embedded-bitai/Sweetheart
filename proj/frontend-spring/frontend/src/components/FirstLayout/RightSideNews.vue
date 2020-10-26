<template>
  <div class="rightSideNews">
    <v-layout>
      <v-card style="width: 250px; height: 150px">
        <v-sheet
          elevation="8"
        >
          <v-slide-group
            class="pa-4"
            active-class="success"
            show-arrows
          >
            <v-slide-item
              v-for="(slide, idx) in this.$store.state.lists"
              :key="idx"
              v-slot:default="{ active }"
            >
              <v-img v-if="slide.image"
                     :src="slide.image"
                     :color="active ? undefined: 'grey lighten-1'"
                     height="200"
                     width="150"
              >
                <v-row
                  class="fill-height"
                  align="center"
                  justify="center"
                >
                </v-row>
              </v-img>
            </v-slide-item>
          </v-slide-group>
        </v-sheet>
      </v-card>
    </v-layout>
    <v-layout style="margin-top: 60px">
      <v-card style="width: 250px; height: 150px">
        <v-sheet
          elevation="8"
        >
          <v-slide-group
            class="pa-4"
            active-class="success"
            show-arrows
          >
            <v-slide-item
              v-for="(slide, idx) in this.$store.state.lists"
              :key="idx"
              v-slot:default="{ active }"
            >
              <v-img v-if="slide.image"
                     :src="slide.image"
                     :color="active ? undefined: 'grey lighten-1'"
                     height="200"
                     width="150"
              >
                <v-row
                  class="fill-height"
                  align="center"
                  justify="center"
                >
                </v-row>
              </v-img>
            </v-slide-item>
          </v-slide-group>
        </v-sheet>
      </v-card>
    </v-layout>
  </div>
</template>

<script>
export default {
  name: 'RightSideNews',
  data () {
    return {
      // userName: this.$store.state.myProfile[0].userName,
      // userId: this.$store.state.myProfile[0].userId,
      // userBirth: this.$store.state.myProfile[0].date,
      curPw: '',
      chPw: '',
      userImg: ''
      // address: this.$store.state.myProfile[0].totalAddress
    }
  },
  created () {
    this.$store.dispatch('crawlNews')
  }
}
</script>

<style src="@/assets/firstLayout.css" scoped/>
