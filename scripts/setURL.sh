#!/bin/sh

export FRONTEND_URL="http://$(oc get route/ossm-frontend -o jsonpath={.spec.host}  -n demo-ossm-frontend)/req"
export KIALI_URL="http://$(oc get route/kiali -o jsonpath={.spec.host} -n demo-ossm-control-plane)"
export GATEWAY_URL="http://$(oc get route.route.openshift.io/istio-ingressgateway -o jsonpath={.spec.host} -n demo-ossm-control-plane)/req"