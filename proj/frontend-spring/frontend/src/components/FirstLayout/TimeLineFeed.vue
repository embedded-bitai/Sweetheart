<template>
  <v-layout column style="margin-top: 10px; width: 700px">
    <v-flex>
      <v-card style="width: 100%; margin-bottom: 10px">
        <v-layout>
          <v-flex>
            <v-expansion-panels
              flat
            >
              <v-expansion-panel style="margin-bottom: 10px">
                <v-expansion-panel-header hide-actions>
                  <v-layout column>
                    <v-layout style="margin: 0 20px 10px 0" >
                      <v-flex style="text-align: start">
                        <v-btn disabled depressed style="background-color: blue; align-content: start">
                          <v-img src="https://cdn.vuetifyjs.com/images/john.jpg"
                                 width="45px" style="margin-right: 5px"
                          ></v-img>
                          <span class="black--text"><h6>2020-10-29 10:29</h6><h3 align="left">LeeMinHo</h3></span>
                        </v-btn>
                      </v-flex>
                      <v-flex style="margin: 10px; text-align: end">
                      </v-flex>
                    </v-layout>
                    <v-layout column>
                      <v-flex>
                        <v-img src="https://cdn.vuetifyjs.com/images/john.jpg" style="width: 100%" height="250px"/>
                      </v-flex>
                      <v-flex>
                        <v-card-text style="width: 100%">
                          오늘은 무슨글을 남겨야 할지 모르겠다.
                          그냥 글을 테스트 용으로 적어두었다. 아하앟아
                        </v-card-text>
                        <v-flex>
                          <v-btn icon style="margin-right: 10px"><span>Like</span></v-btn>
                          <v-btn icon><span>Post</span></v-btn>
                        </v-flex>
                      </v-flex>
                    </v-layout>
                  </v-layout>
                </v-expansion-panel-header>
                <v-expansion-panel-content>
                  <v-layout column>
                    <v-flex>
                      <v-textarea
                        rows="1"
                        placeholder="Please leave a message."
                      ></v-textarea>
                    </v-flex>
                    <v-felx>
                      <li>
                        <v-img src="https://cdn.vuetifyjs.com/images/john.jpg " style="width: 50px"></v-img><span>그냥 쓸께 없어요요요요요요요</span>
                      </li>
                      <li>
                        <v-img src="https://cdn.vuetifyjs.com/images/john.jpg " style="width: 50px"></v-img><span>뭐라도 적어야지.</span>
                      </li>
                    </v-felx>
                  </v-layout>
                </v-expansion-panel-content>
              </v-expansion-panel>
            </v-expansion-panels>
          </v-flex>
        </v-layout>
      </v-card>
    </v-flex>
  </v-layout>
</template>
