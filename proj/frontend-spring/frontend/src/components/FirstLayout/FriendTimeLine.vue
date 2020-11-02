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
        <TimeLineFeed></TimeLineFeed>
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
import TimeLineFeed from '@/components/FirstLayout/TimeLineFeed'
import RightSideAd from '@/components/FirstLayout/RightSideAd'
import RightSideNews from '@/components/FirstLayout/RightSideNews'

export default {
  components: {
    RightSideNews,
    AppBar,
    LeftSideMenu,
    TimeLineFeed,
    RightSideAd
  }
}
</script>

<style src="@/assets/firstLayout.css" scoped/>
