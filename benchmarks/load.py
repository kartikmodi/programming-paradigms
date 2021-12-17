import requests
import concurrent.futures
# import urllib2
import time

start = time.time()
# url = "http://localhost:8090/imperative/itemsNaive"
url = "http://localhost:8090/reactive/items"


# Retrieve a single page and report the url and contents
def load_url(url, timeout):
    headers = {
        'cache-control': "no-cache",
        'postman-token': "c1c3cb49-d123-bc89-5c24-a4432736d3ef"
    }

    response = requests.request("GET", url, headers=headers)
    # print(response.text)
    return response.text


# We can use a with statement to ensure threads are cleaned up promptly
with concurrent.futures.ThreadPoolExecutor(max_workers=1000) as executor:
    # Start the load operations and mark each future with its URL
    future_to_url = {executor.submit(load_url, url, 60) for i in range(2000)}
    for future in concurrent.futures.as_completed(future_to_url):
        try:
            data = future.result()
        except Exception as exc:
            print('%r generated an exception: %s' % (url, exc))
        else:
            print('%r page is %d bytes' % (url, len(data)))
print('Elapsed Time: %ss' % (time.time() - start))
