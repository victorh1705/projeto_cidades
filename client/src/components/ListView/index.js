import React from "react";
import { useSelector } from "react-redux";

export default function ListView() {
  const cidades = useSelector((state) => state.cidades.data);

  /* 
    TODO - criar request para atualizar uma cidade 
    e atualizar a lista
  */
  function updateCity() {}

  /* 
    TODO - criar request para remover uma cidade 
    e atualizar a lista
  */
  function deleteCity() {}

  return (
    <div className="listview">
      {cidades.map((item, index) => {
        return (
          <div key={index.toString()}>
            <label>
              {item.nome} - {item.pais}
            </label>
            <div>
              <span>&#9998;</span> {/* elemento edit */}
              <span>&#10005;</span> {/* elemento remove */}
            </div>
          </div>
        );
      })}
    </div>
  );
}
