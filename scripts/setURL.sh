#!/bin/sh

export FRONTEND_URL="http://$(oc get route/ossm-frontend -o jsonpath={.spec.host}  -n demo-ossm-frontend)/req"
export KIALI_URL="http://$(oc get route/kiali -o jsonpath={.spec.host} -n demo-ossm-control-plane)"