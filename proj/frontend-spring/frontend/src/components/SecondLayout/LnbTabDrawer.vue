<template>
  <v-app>
    <v-tabs vertical height="100vh" icons-and-text>
      <v-tabs-slider color="red"></v-tabs-slider>
      <v-tab>
        <h6>My Home</h6>
        <v-icon>
          mdi-account
        </v-icon>
      </v-tab>
      <v-tab>
        <h6>Friends</h6>
        <v-icon>
          mdi-account-multiple
        </v-icon>
      </v-tab>
      <v-tab>
        <h6>BRANCH</h6>
        <v-icon>
          mdi-map-marker
        </v-icon>
      </v-tab>
      <v-tab>
        <h6>SETTINGS</h6>
        <v-icon>
          mdi-cog
        </v-icon>
      </v-tab>

      <v-tab-item style="width: 15%; height: 100vh">
        <v-navigation-drawer dark clipped>
          <v-list>
            <v-list-item>
                <v-list-item-title>Dashboard</v-list-item-title>
            </v-list-item>
          </v-list>
          <v-list>
            <v-list-item>
              <v-list-item-title>My TimeLine</v-list-item-title>
            </v-list-item>
          </v-list>
        </v-navigation-drawer>
      </v-tab-item>
      <v-tab-item style="width: 15%; height: 100vh">
        <v-navigation-drawer dark clipped>
          <v-list>
            <v-list-item>
              <v-list-item-title>Testing right nav</v-list-item-title>
            </v-list-item>
          </v-list>
        </v-navigation-drawer>
      </v-tab-item>
      <v-tab-item style="width: 15%; height: 100vh">
        <v-navigation-drawer dark clipped>
          <v-list>
            <v-list-item>
              <v-list-item-title>Testing right nav</v-list-item-title>
            </v-list-item>
          </v-list>
        </v-navigation-drawer>
      </v-tab-item>
      <v-tab-item style="width: 15%; height: 100vh">
        <v-navigation-drawer dark clipped>
          <v-list>
            <v-list-item>
              <v-list-item-title>Testing right nav</v-list-item-title>
            </v-list-item>
          </v-list>
        </v-navigation-drawer>
      </v-tab-item>
    </v-tabs>
  </v-app>
</template>

<script>
export default {
  name: 'LnbTabDrawer',
  data () {
    return {
    }
  }
}
</script>
