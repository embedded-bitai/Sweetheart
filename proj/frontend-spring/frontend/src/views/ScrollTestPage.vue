<template>
  <v-app>
    <div>
      <Gnb style="z-index: 1; width: auto"></Gnb>
      <LnbTabDrawer
        style="position: fixed; z-index: 1; width: auto"
        @gotoDashboard="onGotoDashboard"
      ></LnbTabDrawer>
      <div style="position: fixed; margin-left: 300px; z-index: 2; left: auto; top: 10%; width: 75%; border-radius: 15vh; height: 100vh">
        <Timeline></Timeline>
      </div>
    </div>
  </v-app>
</template>

<script>
import Gnb from '@/components/SecondLayout/Gnb'
import LnbTabDrawer from '@/components/SecondLayout/LnbTabDrawer'
import Timeline from '@/components/TimeLine/Timeline'
import { mapGetters } from 'vuex'

export default {
  name: 'ScrollTestPage',
  components: {
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
    }
  },
  computed: {
    ...mapGetters(['isAuthorized'])
  }
}
</script>
