async function attachEvents() {
    let res = await fetch('http://localhost:3030/jsonstore/forecaster/locations');
    let forecastDiv = document.getElementById('forecast');
    let currentDiv = document.getElementById('current');
    let upcoming = document.getElementById('upcoming');

    let data = await res.json();


    let submitBtn = document.getElementById('submit');
    submitBtn.addEventListener('click', getWeather);

    async function getWeather(ev) {
        let input = document.getElementById('location');

        let loc = data.find(l => l.name == input.value);

        if(loc == undefined) {
            forecastDiv.style.display = 'none';
        }else {
            let k = document.getElementsByClassName('forecasts')[0]

          if(k != undefined) {
            currentDiv.removeChild(k);
            let p = document.getElementsByClassName('forecast-info')[0];
            upcoming.removeChild(p);
          }

        forecastDiv.style.display = 'block';

        getCurrentForecast(loc);
        getFor3DaysForecast(loc);
        }

        input.value = '';
    }

    async function getCurrentForecast(loc) {
        let resCurrent = await fetch(`http://localhost:3030/jsonstore/forecaster/today/${loc.code}`);
        let dataCurrent = await resCurrent.json();

        let div = document.createElement('div');
        div.className = 'forecasts';

        let symbolSpan = document.createElement('span');
        symbolSpan.className = 'conditional symbol';
        symbolSpan.innerHTML = getSymbol(dataCurrent.forecast.condition);

       let conditionSpan = document.createElement('span');
       conditionSpan.innerHTML = `<span class="forecast-data">${dataCurrent.name}</span> 
       <span class="forecast-data">${dataCurrent.forecast.low}/${dataCurrent.forecast.high}</span> <span class="forecast-data">${dataCurrent.forecast.condition}</span>`;

        div.appendChild(symbolSpan);
        div.appendChild(conditionSpan);

        currentDiv.appendChild(div);
    }

    async function getFor3DaysForecast(loc) {
        let resFor3 = await fetch(`http://localhost:3030/jsonstore/forecaster/upcoming/${loc.code}`);
        let dataFor3 = await resFor3.json();

        let fDiv = document.createElement('div');
        fDiv.className = 'forecast-info';

        for (const day of dataFor3.forecast) {
            let spanUp = document.createElement('span');
            spanUp.className = 'upcoming';
            spanUp.innerHTML = `<span class="symbol">${getSymbol(day.condition)}</span> 
            <span class="forecast-data">${day.low}/${day.high}</span> 
            <span class="forecast-data">${day.condition}</span>`;
            fDiv.appendChild(spanUp);
        }


        upcoming.appendChild(fDiv);
    }

    function getSymbol(condition) {
        if(condition == 'Sunny') {
            return '&#x2600;';
        }else if(condition == 'Partly sunny') {
            return '&#x26C5;';
        }else if(condition == 'Overcast') {
            return '&#x2601;';
        }else if(condition == 'Rain') {
            return '&#x2614;';
        }else if(condition == 'Degrees') {
            return '&#176;';
        }
    }
   
}

attachEvents();