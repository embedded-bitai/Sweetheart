<template>
  <div class="rightSideNews">
    <v-layout>
      <v-card style="width: 300px; height: 150px">
        <v-sheet
          class="mx-auto"
          elevation="8"
        >
          <v-slide-group
            v-model="model"
            active-class="success"
            show-arrows
          >
            <v-slide-item
              v-for="(slide, idx) in this.$store.state.daumLists"
              :key="idx"
            >
              <v-img v-if="slide.image"
                     :src="slide.image"
                     class="ma-4"
                     width="200"
              >
                <v-row
                  class="fill-height"
                  align="center"
                  justify="center"
                >
                  <v-scale-transition>
                  </v-scale-transition>
                </v-row>
              </v-img>
            </v-slide-item>
          </v-slide-group>
        </v-sheet>
      </v-card>
    </v-layout>
    <v-layout style="margin-top: 10px">
      <v-card style="width: 300px; height: 150px">
        <v-sheet
          class="mx-auto"
          elevation="8"
        >
          <v-slide-group
            v-model="model"
            active-class="success"
            show-arrows
          >
            <v-slide-item
              v-for="(slide, idx) in this.$store.state.naverLists"
              :key="idx"
              v-slot:default="{ active }"
            >
              <v-img v-if="slide.image"
                     :src="slide.image"
                     :color="active ? undefined: 'grey lighten-1'"
                     class="ma-4"
                     width="200"
              >
                <v-row
                  class="fill-height"
                  align="center"
                  justify="center"
                >
                  <v-scale-transition>
                  </v-scale-transition>
                </v-row>
              </v-img>
            </v-slide-item>
          </v-slide-group>
        </v-sheet>
      </v-card>
    </v-layout>
  </div>
</template>

<script>
export default {
  data () {
    return {
      model: null,
      address: ''
    }
  },
  created () {
    this.$store.dispatch('crawlDaumNews')
    this.$store.dispatch('crawlNaverNews')
  }
}
</script>

<style src="@/assets/firstLayout.css" scoped/>
