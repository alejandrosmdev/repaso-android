const express = require('express');
const { Pool } = require('pg');
const app = express();

const pool = new Pool({
    host: "localhost",
    database: "postgres",
    user: "postgres",
    password: "postgres",
    port: "5432"
});

app.use(express.json());

// Obtener productos
app.get("/productos", async(req,res)=>{
    try {
        const result = pool.query(
            "SELECT * FROM public.productos"
        );

        res.json((await result).rows);

    } catch (error) {
        return res.status(500).send(`Error al obtener los productos: ${error}`);
    }
});

// Obtener categorias
app.get("/categorias", async(req,res)=>{
    try {
        const result = pool.query(
            "SELECT * FROM public.categorias"
        );

        res.json((await result).rows);

    } catch (error) {
        return res.status(501).send(`Error al obtener las categorias: ${error}`);
    }
});

// Obtener productos por categoria
app.get("/productos/categoria/:id", async(req, res)=>{
    const categoriaId = req.params.id;
    try {
        const result = pool.query(
            "SELECT * FROM public.productos WHERE categoria_id = $1",
            [categoriaId]
        );

        res.json((await result).rows);

    } catch (error) {
        return res.status(502).send(`Error al obtener los productos por categoria: ${error}`);
    }
});

// Obtener productos por nombre
app.get('/productosPorNombre', async (req, res) => {
    const nombreProducto = req.query.nombre;
    if (!nombreProducto) {
        return res.status(400).send('El parámetro "nombre" es requerido');
    }
    try {
        const result = await pool.query(
            "SELECT * FROM public.productos WHERE nombre ILIKE $1",
            [`%${nombreProducto}%`]
        );

        res.json(result.rows);

    } catch (error) {
        return res.status(502).send(`Error al obtener los productos por nombre: ${error}`);
    }
});

const PORT = 3000;
app.listen(PORT, async(req, res)=>{
    console.log(`Servidor corriendo por el puerto ${PORT}`);
})