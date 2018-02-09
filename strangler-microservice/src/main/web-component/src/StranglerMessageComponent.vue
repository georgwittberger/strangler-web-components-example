<template>
  <div class="card" id="strangler-message-component">
    <div class="card-body">
      <h2 class="card-title">Message Component</h2>
      <p class="card-text">This component is provided by the microservice
         and the following message is loaded from its API:</p>
      <p class="card-text text-primary">{{ message }}</p>
    </div>
  </div>
</template>

<script>
import Vue from 'vue';
import Component from 'vue-class-component';

@Component({
  name: 'StranglerMessageComponent',
  props: {
    /** Base URL of the microservice to send API requests to */
    serverBaseUrl: String,
  },
})
export default class StranglerMessageComponent extends Vue {
  message = null;

  mounted() {
    fetch(`${this.serverBaseUrl}/message`, {
      headers: new Headers({
        Accept: 'application/json',
      }),
    })
      .then((response) => {
        if (response.ok) return response.json();
        throw new Error(`Server error: ${response.status} ${response.statusText}`);
      })
      .then((response) => {
        this.message = response.message;
      })
      .catch((error) => {
        console.error('Could not load message!', error); // eslint-disable-line no-console
      });
  }
}
</script>

<style scoped>

</style>
