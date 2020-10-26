<template>
  <div class="dashBoard">
    <v-layout>
      <v-flex>
        <AppBar></AppBar>
      </v-flex>
    </v-layout>
    <v-layout id="contents_area">
      <v-flex id="left_area" style="width: 50%; height: max-content">
        <LeftSideMenu></LeftSideMenu>
      </v-flex>
      <v-flex id="middle_area" style="width: 60%">
        <TimeLine></TimeLine>
      </v-flex>
      <v-flex id="right_area" style="width: 50%">
        <RightSideNews></RightSideNews>
        <RightSideAd></RightSideAd>
      </v-flex>
    </v-layout>
  </div>
</template>
<script>
import AppBar from '@/components/FirstLayout/AppBar'
import LeftSideMenu from '@/components/FirstLayout/LeftSideMenu'
import TimeLine from '@/components/FirstLayout/TimeLine'
import RightSideNews from '@/components/FirstLayout/RightSideNews'
import RightSideAd from '@/components/FirstLayout/RightSideAd'

export default {
  components: {
    AppBar,
    LeftSideMenu,
    TimeLine,
    RightSideNews,
    RightSideAd
  }
}
</script>

<style src="@/assets/firstLayout.css" scoped/>
