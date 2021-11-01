# skaffold-kpt-example

A sample application using jib, skaffold, and kpt.

## Building and Pushing Container Image

```
./gradlew jib
```

## Substituting and Setting Up Variables using Kpt

Using the following command, you can change the namespace of the dev environment:
```
kpt fn eval --image gcr.io/kpt-fn/apply-setters:v0.2 -- environment=dev
skaffold dev --port-forward
```

This will run your code in your cluster while allowing port connection to your local

## Rendering using Skaffold and Deploy to Prod

```
skaffold render-clean artifact-archive/kubernetes/skaffold-kpt-example.yaml
skaffold build -platest
```
