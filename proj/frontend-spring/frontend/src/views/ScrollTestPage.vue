<template>
  <v-app>
    <div v-if="isAuthorized">
      <Gnb style="z-index: 1; width: auto"></Gnb>
      <LnbTabDrawer
        style="position: fixed; z-index: 1; width: auto"
        @gotoDashboard="onGotoDashboard"
        @gotoMyPage="onGotoMypage"
      ></LnbTabDrawer>
      <div style="position: fixed; margin-left: 300px; z-index: 2; left: auto; top: 10%; width: 75%; border-radius: 15vh; height: 100vh">
        <Timeline v-if="screenName == 'myTimeline'"></Timeline>
        <MyPage
          v-if="screenName == 'myPage'"
        ></MyPage>
      </div>
    </div>
    <div v-else>
      로그인을 해주세요<br>
    </div>
  </v-app>
</template>

<script>
import Gnb from '@/components/SecondLayout/Gnb'
import LnbTabDrawer from '@/components/SecondLayout/LnbTabDrawer'
import Timeline from '@/components/TimeLine/Timeline'
import MyPage from '@/components/Settings/MyPage'
import { mapGetters } from 'vuex'

export default {
  name: 'ScrollTestPage',
  components: {
    MyPage,
    Timeline,
    LnbTabDrawer,
    Gnb
  },
  data () {
    return {
      screenName: 'myTimeline'
    }
  },
  methods: {
    onGotoDashboard () {
      this.screenName = 'myTimeline'
    },
    onGotoMypage () {
      this.screenName = 'myPage'
    }
  },
  computed: {
    ...mapGetters(['isAuthorized'])
  }
}
</script>
