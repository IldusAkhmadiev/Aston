	Добавлен Maven для JUnit5 
 
	Если при запуске метода main в BattleGround выходит окошко 
 
		Указать Java версию (поддерживает любую версию с 8 до 22) 
  		и проект как показано на скриншоте
![image](https://github.com/user-attachments/assets/57a8c132-53b7-4cd5-9aaf-76a8135f2719)



لإ

Если не получилось запускать можно и через DOCKER доступные версии

                docker run ildusakhmadiev/aston:lesson4v1 

                Не поддерживает передачу параметров
              
                 
                docker run  ildusakhmadiev/aston:latest
 
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
