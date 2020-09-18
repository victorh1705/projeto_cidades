import React, { useState, useEffect } from "react";
import { useDispatch } from "react-redux";
import { actions } from "./store/ducks/cidades";

import api from "./services/api";
import ListView from "./components/ListView";

import "./App.css";

export default function App() {
  const dispatch = useDispatch();
  const [formulario, setFormulario] = useState(null);

  function handleInputChange(e) {
    const objeto = {};
    objeto[e.target.name] = e.target.value;
    setFormulario((prev) => ({ ...prev, ...objeto }));
  }

  function handleSubmit(e) {
    e.preventDefault();
    insertNewCity();
  }

  /* Busca todas as Cidades e salvar no REDUX */
  function getAllCities() {
    api
      .get("/cidades")
      .then((res) => {
        dispatch(actions.setListCidades(res.data));
      })
      .catch((err) => {
        console.error(err);
      });
  }

  /* Inseri uma nova Cidade e faz a busca */
  function insertNewCity() {
    api
      .post("/cidades", formulario)
      .then((res) => {
        getAllCities();
      })
      .catch((err) => {
        console.error(err);
      });
  }

  useEffect(() => {
    getAllCities();
  }, []);

  return (
    <div className="app">
      <h3>CADASTRO DE CIDADES</h3>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="nome"
          placeholder="Nome"
          onChange={handleInputChange}
          required
        />
        <input
          type="text"
          name="pais"
          placeholder="País"
          onChange={handleInputChange}
          required
        />
        <input
          type="text"
          name="latitude"
          placeholder="Latitude"
          onChange={handleInputChange}
          required
        />
        <input
          type="text"
          name="longitude"
          placeholder="Longitude"
          onChange={handleInputChange}
          required
        />

        <button>SALVAR</button>
      </form>

      <h3>CIDADES CADASTRADAS</h3>
      <ListView />
    </div>
  );
}
