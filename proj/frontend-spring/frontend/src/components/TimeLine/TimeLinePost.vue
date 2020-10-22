<template>
  <v-container class="pa-5">
    <v-card class="mt-5" v-for="(timeline, idx) in timelinePost" :key="idx">
      <v-toolbar flat class="mb-5">
        <v-layout justify-center style="max-width: 100%">
          <v-flex class="mr-4 mt-2" style="max-width: 10%">
            <img
              src="https://cdn.vuetifyjs.com/images/john.jpg"
              style="max-width: 100%"
            >
          </v-flex>
          <v-flex>
            <v-layout class="mt-2" column>
              <span class="text-h7">{{ this.name }}</span>
              <span class="text-h7">{{ timeline.regDate }}</span>
<!--              <span v-if="timeline[idx].regDate" class="text-h9">{{ timeline[0].regDate }}</span>-->
            </v-layout>
          </v-flex>
        </v-layout>
      </v-toolbar>
      <v-layout justify-center column style="height: auto">
        <span class="text-h7">{{ timeline.content }}</span>
      </v-layout>
    </v-card>
  </v-container>
</template>

<script>
import axios from 'axios'

export default {
  name: 'TimeLinePost',
  data () {
    return {
      name: this.$store.state.myProfile.name,
      image: null,
      regDate: null,
      contents: null,
      timelinePost: []
    }
  },
  created () {
    // const userNo = this.$store.state.myInfo.userNo
    axios.get('http://localhost:7777/timeline/list/all/')
      .then(res => {
        console.log('get timeline post')
        this.timelinePost = res.data
      })
      .catch(err => {
        console.log('created()' + err.response)
      })
    // axios.get(`http://localhost:7777/timeline/list/${userNo}`)
    //   .then(res => {
    //     console.log('get timeline post')
    //     this.timelinePost = res.data
    //   })
    //   .catch(err => {
    //     console.log('created()' + err.response)
    //   })
  }
}
</script>
