<template>
  <v-container class="pa-5">
    <v-card>
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
              <span class="text-h7">이름</span>
              <span class="text-h9">날짜</span>
            </v-layout>
          </v-flex>
        </v-layout>
      </v-toolbar>
      <v-layout justify-center column style="height: auto">
        <p>게시글 이미지</p>
        <p>게시글 내용</p>
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
      image: null,
      contents: null,
      userNo: this.$store.state.myInfo.userNo,
      timelinePost: []
    }
  },
  created () {
    axios.get('http://localhost.7777/timeline/list', this.userNo)
      .then(res => {
        console.log('get timeline post')
        this.timelinePost = res.data
      })
      .catch(err => {
        console.log(err.response)
      })
  }
}
</script>
