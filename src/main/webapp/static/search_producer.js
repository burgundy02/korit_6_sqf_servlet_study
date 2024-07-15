function handleSearchClick() {
         const searchInput = document.querySelector(".search-input");
         // 해당 주소로 이동										// searchText의 값이 searchInput의 value
         location.href = `http://localhost:8080/dvd/search?searchText=${searchInput.value}`;
      }