<template>
  <q-layout view="lHh Lpr lFf">
    <q-header elevated>
      <q-toolbar>
        <q-btn
          flat
          dense
          round
          icon="menu"
          aria-label="Menu"
          @click="toggleLeftDrawer"
        />

        <q-toolbar-title> 건물성능개선사업 </q-toolbar-title>
        <div>
          <q-btn
            flat
            round
            dense
            :icon="darkModeIcon"
            @click="toggleDarkMode"
          />
          <!--          <q-btn flat round dense icon="dark_mode" />-->
          <q-btn round size="sm" class="q-mr-md">
            <q-avatar size="42px">
              <img src="/avatar-bg.svg" />
            </q-avatar>
            <q-menu :offset="[0, 10]">
              <q-list style="min-width: 100px">
                <q-separator />
                <q-item clickable v-close-popup to="/auth/sign-in">
                  <q-item-section>로그아웃</q-item-section>
                </q-item>
              </q-list>
            </q-menu>
          </q-btn>
        </div>
      </q-toolbar>
    </q-header>

    <q-drawer v-model="leftDrawerOpen" show-if-above bordered>
      <q-list>
        <q-item-label header> 페이지 구성 리스트 </q-item-label>

        <EssentialLink
          v-for="link in essentialLinks"
          :key="link.title"
          v-bind="link"
        />
      </q-list>
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script>
const linksList = [
  {
    title: "Dash Board",
    caption: "대시보드 페이지",
    icon: "school",
    to: "/dash-board",
  },
  {
    title: "Sign In",
    caption: "로그인",
    icon: "school",
    to: "/sign-in",
  },
];
</script>

<script setup>
import { computed, ref } from "vue";
import EssentialLink from "components/EssentialLink.vue";
import { useQuasar } from "quasar";

const $q = useQuasar();

const leftDrawerOpen = ref(false);
const essentialLinks = linksList;
const toggleLeftDrawer = () => {
  leftDrawerOpen.value = !leftDrawerOpen.value;
};
const darkModeIcon = computed(() =>
  $q.dark.isActive ? "dark_mode" : "light_mode",
);

const toggleDarkMode = () => {
  $q.dark.toggle();
  $q.localStorage.set("darkMode", $q.dark.isActive);
};
</script>
