<template>
  <q-page>
    <div v-if="loading">로딩 중...</div>
    <div v-else>
      <!-- 데이터를 표시합니다 -->
      {{ axiosPinia.data }}
    </div>
  </q-page>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useAxiosPiniaStore } from 'stores/axiosPinia';
import { api } from 'boot/axios';

const axiosPinia = useAxiosPiniaStore();
const loading = ref(false); // ref를 사용하여 로딩 상태를 정의합니다

const test = async () => {
  loading.value = true; // 데이터를 가져오기 전에 로딩 상태를 true로 설정
  try {
    await axiosPinia.fetchData(api);
  } catch (error) {
    // 컴포넌트에서 에러를 처리하고 필요한 경우 출력합니다
    console.error('컴포넌트에서 에러 발생:', error);
  } finally {
    loading.value = false; // 데이터 가져오기 성공 여부에 상관없이 로딩 상태를 false로 설정
  }
};

onMounted(test);
</script>
