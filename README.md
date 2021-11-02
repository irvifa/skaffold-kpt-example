# skaffold-kpt-example

A sample application using jib, skaffold, and kpt.

## Building and Pushing Container Image

Directly using Jib:
```
./gradlew jib
```

Using Skaffold:
```
make image-build
```

## Substituting and Setting Up Variables using Kpt

Using the following command, you can change the namespace of the dev environment:
```
kpt fn eval --image gcr.io/kpt-fn/apply-setters:v0.2 -- environment=dev
```
Other alternative will be:
```
kpt fn render
```
Running the application on your local machine:
```
skaffold dev --port-forward
```

This will run your code in your cluster while allowing port connection to your local

## Rendering Prod Manifests

```
make clean && make render
```
