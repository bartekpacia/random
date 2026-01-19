const express = require("express")

const app = express()

const port = process.env.port || 3000

app.get('/', (req, res) => {
    res.send('hi')
})

app.listen(port, () => {
    console.log(`server app listening on port ${port}`)
})
