<template>
  <q-page class="q-pa-md">
    <section class="q-mb-xl">
      <div class="text-h5">대시보드</div>
      <q-separator class="q-my-md"></q-separator>
      <table-component></table-component>
      <table-component2></table-component2>
    </section>
  </q-page>
</template>
<script setup>
import TableComponent from "components/TableComponent.vue";
import TableComponent2 from "components/TableComponent2.vue";
</script>

<style lang="scss" scoped></style>
