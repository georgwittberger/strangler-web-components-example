<template>
  <div class="card" id="strangler-greeting-component">
    <div class="card-body">
      <h2 class="card-title">Greeting Component</h2>
      <p class="card-text">This component is provided by the microservice
         and makes use of session-specific data from the monolith:</p>
      <p class="card-text text-primary">{{ greeting }}</p>
    </div>
  </div>
</template>

<script>
import Vue from 'vue';
import Component from 'vue-class-component';

@Component({
  name: 'StranglerGreetingComponent',
  props: {
    /** Base URL of the microservice to send API requests to */
    serverBaseUrl: String,
    /** Name of the session cookie to be sent to the monolith for user authentication */
    monolithSessionCookieName: String,
    /** Value of the session cookie to be sent to the monolith for user authentication */
    monolithSessionCookieValue: String,
  },
})
export default class StranglerGreetingComponent extends Vue {
  greeting = null;

  mounted() {
    // Request greeting by calling the API of the microservice
    fetch(`${this.serverBaseUrl}/greeting`, {
      headers: new Headers({
        Accept: 'application/json',
        // Send the session cookie data to the microservice which
        // allows it to access the monolith on behalf of the user.
        'X-Monolith-Session-Cookie-Name': this.$props.monolithSessionCookieName,
        'X-Monolith-Session-Cookie-Value': this.$props.monolithSessionCookieValue,
      }),
    })
      .then((response) => {
        if (response.ok) return response.json();
        throw new Error(`Server error: ${response.status} ${response.statusText}`);
      })
      .then((response) => {
        this.greeting = response.greeting;
      })
      .catch((error) => {
        console.error('Could not load greeting!', error); // eslint-disable-line no-console
      });
  }
}
</script>

<style scoped>

</style>
