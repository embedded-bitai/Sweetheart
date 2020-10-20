<template>
  <v-app>
    <Gnb style="z-index: 1"></Gnb>
    <LnbTabDrawer
      style="position: fixed; z-index: 1; width: 90%"
      @gotoMyTimeline="gotoMyTimeline"
      @gotoMyPage="onGotoMypage"
    ></LnbTabDrawer>
    <div style="position: fixed; z-index: 2; left: 17.7%; top: 10%; width: 75%; border-radius: 10vh; overflow-y: scroll;">
      <Timeline v-if="screenName == 'myTimeline'"></Timeline>
      <MyPage
        v-if="screenName == 'myPage'"
      ></MyPage>
    </div>
  </v-app>
</template>

<script>
import Gnb from '@/components/SecondLayout/Gnb'
import LnbTabDrawer from '@/components/SecondLayout/LnbTabDrawer'
import Timeline from '@/components/SecondLayout/Timeline'
import MyPage from '@/components/Settings/MyPage'

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
    gotoMyTimeline () {
      this.screenName = 'myTimeline'
    },
    onGotoMypage () {
      this.screenName = 'myPage'
    }
  }
}
</script>
