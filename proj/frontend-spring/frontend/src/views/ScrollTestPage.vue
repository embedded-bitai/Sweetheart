<template>
  <v-app>
    <Gnb style="z-index: 1"></Gnb>
    <LnbTabDrawer style="position: fixed; z-index: 1; width: 90%"></LnbTabDrawer>
    <div style="position: fixed; z-index: 2; left: 17.7%; top: 10%; width: 75%; border-radius: 10vh; overflow-y: scroll;">
      <Timeline v-if="screenNum == 1"></Timeline>
    </div>
  </v-app>
</template>

<script>
import Gnb from '@/components/SecondLayout/Gnb'
import LnbTabDrawer from '@/components/SecondLayout/LnbTabDrawer'
import Timeline from '@/components/SecondLayout/Timeline'

export default {
  name: 'ScrollTestPage',
  components: {
    Timeline,
    LnbTabDrawer,
    Gnb
  },
  data () {
    return {
      screenNum: 1
    }
  }
}
</script>
