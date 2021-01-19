export GATEWAY_URL="http://$(oc get route.route.openshift.io/istio-ingressgateway -o jsonpath={.spec.host} -n demo-ossm-control-plane)/req"
echo $GATEWAY_URL

