Запускать можно и через DOCKER доступные версии

                DOCKER RUN ildusakhmadiev/aston:lesson4v1 

                Не поддерживает передачу параметров
              
                 
                DOCKER RUN  ildusakhmadiev/aston:latest
 
                Поддерживает передачу 2 параметров	
   
--herotype

     		Archer
        
			Mag
   
   			Warrior
      
--enemytype

			Enemy
   
   			Zombie
      
      		Troll
    		
	
https://hub.docker.com/repository/docker/ildusakhmadiev/aston/general


Доступные классы героев:

	Лучник супер прием 2х урон

	Маг лечит случайного героя

	Воин супер удар 3х удар


Доступные классы врагов:

	Enemy - без суперспособностей

	Zombie - шанс воскреситься после смерти (не разовый)

	Troll - супер удар 3х урон


Параметры:


	health - здоровье
	basicDamage - базовый урон
	name - Имя
	procentSuccessAbility - % вероятности срабатывания супер умения у героев и у вражеских героев
