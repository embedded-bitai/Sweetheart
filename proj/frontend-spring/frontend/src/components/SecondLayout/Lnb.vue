<template>
  <div id="app">
    <v-app id="inspire" style="max-height: 0px">
      <v-layout>
        <v-navigation-drawer
          style="z-index:2"
          v-model="leftMenu"
          app
          clipped
          width="3.5%"
        >
          <v-list>
            <v-list-item class="pl-0" @click="checkNavigationMenuClick">
              <v-list-tile-action>
                <v-layout @click="rightMenu = !rightMenu">
                  <v-icon :color="models.base ? 'green' : 'red'">mdi-dots-vertical</v-icon>
                  <v-icon>mdi-android</v-icon>
                </v-layout>
              </v-list-tile-action>
            </v-list-item>
          </v-list>
        </v-navigation-drawer>
        <v-navigation-drawer id="nav2"
                             dark
                             style="z-index:1;"
                             v-model="rightMenu"
                             width="13%"
                             app
                             clipped
                             pre
        >
          <v-list>
            <v-list-item>
              <v-list-tile-action>
                <v-icon>mdi-android</v-icon>
              </v-list-tile-action>
              <v-list-tile-content>
                <v-list-tile-title>Testing right nav</v-list-tile-title>
              </v-list-tile-content>
            </v-list-item>
          </v-list>
        </v-navigation-drawer>
      </v-layout>
    </v-app>
  </div>
</template>

<script>

export default {
  name: 'Lnb',
  data () {
    return {
      mini: true,
      leftMenu: true,
      rightMenu: false,
      models: {
        base: false,
        conditional: false
      }
    }
  },
  methods: {
    checkNavigationMenuClick () {
      if (this.models.base === true) {
        this.models.base = false
      } else {
        this.models.base = true
      }
    }
  }
}
</script>
