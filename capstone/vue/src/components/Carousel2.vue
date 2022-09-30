<template>
  <v-sheet class="mx-auto" elevation="8" max-width="1700">
    <v-slide-group
      v-model="model"
      class="pa-4"
      active-class="success"
      show-arrows
    >
      <v-slide-item
        v-for="n in Object.keys(volumes)"
        :key="volumes[n].id"
        v-slot="{ active, toggle }"
      >
        <v-card
          :color="active ? undefined : 'grey lighten-1'"
          class="ma-4"
          height="400"
          width="300"
          @click="toggle"
        >
          {{ volumes[n].title }}
          <v-img height="100%" :src="volumes[n].image">
            <v-row class="fill-height" align="center" justify="center">
              <v-scale-transition>
                <!-- <v-icon
                v-if="active"
                color="white"
                size="48"
                v-text="'mdi-close-circle-outline'"
              ></v-icon> -->
              </v-scale-transition>
            </v-row>
          </v-img>
        </v-card>
      </v-slide-item>
    </v-slide-group>
  </v-sheet>
</template>

<script>
import VolumeService from "../services/VolumeService";
export default {
  data: () => ({
    model: null,
    volumes: [],
  }),
  created() {
    VolumeService.getAllVolumes().then((response) => {
      console.log(response.data);
      this.volumes = response.data;
      this.$store.commit("LOAD_ALL_VOLUMES", this.volumes);
    });
  },
};
</script>

<style scoped>
.v-card {
  border-radius: 4px;
  margin: 16px;
}

.v-icon {
  align-items: center;
}
</style>