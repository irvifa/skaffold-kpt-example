kube_ctx := kind-kubernetes-days-id-demo
artifacts_dir := artifacts
apply_setters_image := gcr.io/kpt-fn/apply-setters:v0.2
kpt_live = kpt live --context $(kube_ctx)
kpt_fn := kpt fn
kpt_pkg_init := kpt pkg init
kpt_live_init := kpt live init
kpt_live_destroy := kpt live destroy

.kubeconfig:
	kubectl config use-context kind-kubernetes-days-id-demo

export KUBECONFIG := $(	call .kubeconfig)

image-build:
	skaffold build

render-dev:
	$(kpt_fn) eval --image $(apply_setters_image) -- environment=dev
	skaffold render | kpt fn sink artifacts

clean:
	rm -rf artifacts

pkg-init:
	$(kpt_pkg_init) $(artifacts_dir)

live-init:
	$(kpt_live_init) $(artifacts_dir)

apply:
	$(kpt_live) apply $(artifacts_dir)

destroy:
	$(kpt_live_destroy) $(artifacts_dir)

render:
	skaffold render -pprod | $(kpt_fn) sink $(artifacts_dir)
