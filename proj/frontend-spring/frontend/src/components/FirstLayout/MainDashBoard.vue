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
        <TimeLinePost></TimeLinePost>
        <MyTimeLineFeed></MyTimeLineFeed>
      </v-flex>
      <v-flex id="right_area" style="width: 50%">
        <div style="position: sticky; top: 10px">
          <RightSideNews></RightSideNews>
          <RightSideAd></RightSideAd>
        </div>
      </v-flex>
    </v-layout>
  </div>
</template>
<script>
import AppBar from '@/components/FirstLayout/AppBar'
import LeftSideMenu from '@/components/FirstLayout/LeftSideMenu'
import MyTimeLineFeed from '@/components/FirstLayout/MyTimeLineFeed'
import RightSideNews from '@/components/FirstLayout/RightSideNews'
import RightSideAd from '@/components/FirstLayout/RightSideAd'
import TimeLinePost from '@/components/FirstLayout/TimeLinePost'

export default {
  components: {
    TimeLinePost,
    AppBar,
    LeftSideMenu,
    MyTimeLineFeed,
    RightSideNews,
    RightSideAd
  }
}
</script>

<style src="@/assets/firstLayout.css" scoped/>
