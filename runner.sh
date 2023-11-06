#!/bin/bash

#-------------------------------------------------------------------
#  This script expects the following environment variables
#     HUB_HOST
#     BROWSER
#     THREAD_COUNT
#     TEST_SUITE
#-------------------------------------------------------------------

# Let's print what we have received
echo "-------------------------------------------"
echo "HUB_HOST      : ${HUB_HOST}"
echo "BROWSER       : ${BROWSER}"
echo "THREAD_COUNT  : ${THREAD_COUNT}"
echo "TEST_SUITE    : ${TEST_SUITE}"
echo "UI_URL        : ${UI_URL}"
echo "-------------------------------------------"

# Do not start the tests immediately. Hub has to be ready with browser nodes
echo "Checking if hub is ready..!"
echo "Hub address: http://${HUB_HOST}:4444"
count=0
while [ "$( curl -s http://${HUB_HOST}:4444/status | jq -r .value.ready )" != "true" ]
do
  count=$((count+1))
  echo "Attempt: ${count}"
  if [ "$count" -ge 30 ]
  then
      echo "**** HUB IS NOT READY WITHIN 30 SECONDS ****"
      exit 1
  fi
  sleep 1
done

# At this point, selenium grid should be up!
echo "Selenium Grid is up and running. Running the test...."

# Start the java command
java -cp 'libs/*' \
     -Dselenium.grid.enabled=true \
     -Dselenium.grid.hubHost="${HUB_HOST}" \
     -Dbrowser="${BROWSER}" \
     -Dui.url="${UI_URL}" \
     org.testng.TestNG \
     -threadcount "${THREAD_COUNT}" \
     test-suites/"${TEST_SUITE}"