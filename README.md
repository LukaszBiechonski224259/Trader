# Trader
zadanie rekrutacyjne - funkcjonalność wymiany walut
cel: 
Przygotowanie aplikowalnej funkcjonalności pozwalającej klientom na operacje pieniężne.
Klient domyslnie posiada rachunki w trzech walutach - EUR, PLN, USD.
Dostepne operacje: 
  wpłata pieniędzy na wybrany rachunek,
  wypłata z wybranego rachunku, 
  transfer środków pomiędzy rachunkami
  przelew na wybrany rachunek innego klienta
  sprawdzenie stanu konta
Klient moze dodatkowo pobrać całościową historię transakcji, oraz szczegółową dla rodzaju operacji, konkretnej waluty, zakresu dat.

Otrzymany feedback:
"Powinieneś przede wszystkim zwrócić uwagę na odpowiednie zaplanowanie architektury (wykorzystanie repozytoriów, serwisów), warstwy powinny bazować na abstrakcjach nie na konkretnych implementacjach (odpowiednie użycie interfejsów) zaś modele domenowe powinny być wolne od logiki i służyć do przechowywania informacji."
