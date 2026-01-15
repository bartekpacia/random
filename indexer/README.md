# indexer

A simple indexer written in Java.

### Usage

Fetch the sample data:

```sh
./get_data
```

Run a simple search without using an index:

```sh
./indexer search-dumb ./data/the_holow_men.txt "we"
```

To use an index, first start the indexer:

```sh
./indexer build-index ./data/pride_and_prejudice.txt
```

Then connect to the indexer over a Unix Domain Socket and query it:

```
./indexer query "world"
```

### Resources

Obtained from Project Gutenberg.

