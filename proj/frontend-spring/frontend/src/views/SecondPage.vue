<template>
  <v-app style="position: fixed">
    <Gnb style="z-index: 1"></Gnb>
    <LnbTabDrawer style="position: fixed; z-index: 1; width: 100%"></LnbTabDrawer>
    <Timeline style="position: fixed; z-index: 2; left: 20%; top: 10%; width: 73%"></Timeline>
  </v-app>
</template>

<script>
import Gnb from '@/components/SecondLayout/Gnb'
import Timeline from '@/components/SecondLayout/Timeline'
import LnbTabDrawer from '@/components/SecondLayout/LnbTabDrawer'

export default {
  name: 'Second',
  components: {
    LnbTabDrawer,
    Timeline,
    Gnb
  }
}
</script>
