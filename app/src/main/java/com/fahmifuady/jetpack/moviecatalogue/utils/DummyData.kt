package com.fahmifuady.jetpack.moviecatalogue.utils

import com.fahmifuady.jetpack.moviecatalogue.data.source.local.entity.MovieEntity
import com.fahmifuady.jetpack.moviecatalogue.data.source.remote.response.MovieResponse
import com.fahmifuady.jetpack.moviecatalogue.data.source.remote.response.TvResponse

object DummyData {

    fun generateMovies(): List<MovieEntity>{

        val m = ArrayList<MovieEntity>()

        m.add(MovieEntity(
                "mv0", "Honset Thief", "2020", "1h 38m",
                "72%", "Action, Thriller, Crime, Drama",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/zeD4PabP6099gpE0STWJrJrCBCs.jpg",
                "A bank robber tries to turn himself in because he\'s falling in love and wants to live an honest life...but when he realizes the Feds are more corrupt than him, he must fight back to clear his name.",
                false
        ))

        m.add(MovieEntity(
                "mv1", "Godmothered", "2020", "1h 53m",
                "72%", "Family, Fantasy, Comedy",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/ir8Qqi90mENhH7CDxEpdeCcm6UL.jpg",
                "A young and unskilled fairy godmother that ventures out on her own to prove her worth by tracking down a young girl whose request for help was ignored. What she discovers is that the girl has now become a grown woman in need of something very different than a \"prince charming.\"",
                false
        ))

        m.add(MovieEntity(
                "mv2", "Wonder Woman 1984 ", "2020", "2h 31m",
                "78%", "Fantasy, Action, Adventure",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/di1bCAfGoJ0BzNEavLsPyxQ2AaB.jpg",
                "Wonder Woman comes into conflict with the Soviet Union during the Cold War in the 1980s and finds a formidable foe by the name of the Cheetah.",
                false
        ))
        
        m.add(MovieEntity(
                "mv3", "Mulan", "2020", "1h 55m",
                "71%", "Action, Adventure, Drama, Fantasy",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/aKx1ARwG55zZ0GpRvU2WrGrCG9o.jpg",
                "When the Emperor of China issues a decree that one man per family must serve in the Imperial Chinese Army to defend the country from Huns, Hua Mulan, the eldest daughter of an honored warrior, steps in to take the place of her ailing father. She is spirited, determined and quick on her feet. Disguised as a man by the name of Hua Jun, she is tested every step of the way and must harness her innermost strength and embrace her true potential.",
                false
        ))

        m.add(MovieEntity(
                "mv4", "Over the Moon ", "2020", "1h 40m",
                "76%", "Animation, Adventure, Family, Fantasy",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lQfdytwN7eh0tXWjIiMceFdBBvD.jpg",
                "In this animated musical, a girl builds a rocket ship and blasts off, hoping to meet a mythical moon goddess.",
                false
        ))

        m.add(MovieEntity(
                "mv5", "Joker", "2019", "2h 2m",
                "82%", "Crime, Thriller, Drama",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg",
                "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",
                false
        ))

        m.add(MovieEntity(
                "mv6", "Bad Boys for Life ", "2020", "2h 4m",
                "73%", "Thriller, Action, Crime",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/y95lQLnuNKdPAzw9F9Ab8kJ80c3.jpg",
                "Marcus and Mike are forced to confront new threats, career changes, and midlife crises as they join the newly created elite team AMMO of the Miami police department to take down the ruthless Armando Armas, the vicious leader of a Miami drug cartel.",
                false
        ))

        m.add(MovieEntity(
                "mv7", "Mortal Kombat Legends: Scorpion's Revenge", "2020", "1h 20m",
                "84%", "Fantasy, Action, Adventure, Animation",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/4VlXER3FImHeFuUjBShFamhIp9M.jpg",
                "After the vicious slaughter of his family by stone-cold mercenary Sub-Zero, Hanzo Hasashi is exiled to the torturous Netherrealm. There, in exchange for his servitude to the sinister Quan Chi, he’s given a chance to avenge his family – and is resurrected as Scorpion, a lost soul bent on revenge. Back on Earthrealm, Lord Raiden gathers a team of elite warriors – Shaolin monk Liu Kang, Special Forces officer Sonya Blade and action star Johnny Cage – an unlikely band of heroes with one chance to save humanity. To do this, they must defeat Shang Tsung’s horde of Outworld gladiators and reign over the Mortal Kombat tournament.",
                false
        ))

        m.add(MovieEntity(
                "mv8", "Alladin", "2019", "2h 8m",
                "72%", "Adventure, Fantasy, Romance, Family",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/ykUEbfpkf8d0w49pHh0AD2KrT52.jpg",
                "A kindhearted street urchin named Aladdin embarks on a magical adventure after finding a lamp that releases a wisecracking genie while a power-hungry Grand Vizier vies for the same lamp that has the power to make their deepest wishes come true.",
                false
        ))

        m.add(MovieEntity(
                "mv9", "A Silent Voice", "2016", "2h 10m",
                "84%", "Animation, Drama, Romance",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/drlyoSKDOPnxzJFrRWGqzDsyJvR.jpg",
                "Shouya Ishida starts bullying the new girl in class, Shouko Nishimiya, because she is deaf. But as the teasing continues, the rest of the class starts to turn on Shouya for his lack of compassion. When they leave elementary school, Shouko and Shouya do not speak to each other again... until an older, wiser Shouya, tormented by his past behaviour, decides he must see Shouko once more. He wants to atone for his sins, but is it already too late...?",
                false
        ))

        m.add(MovieEntity(
                "mv10", "Tenet ", "2020", "2h 30m",
                "74%", "Action, Thriller, Science Fiction",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/k68nPLbIST6NP96JmTxmZijEvCA.jpg",
                "Armed with only one word - Tenet - and fighting for the survival of the entire world, the Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.",
                false
        ))

        m.add(MovieEntity(
                "mv11", "A Whisker Away ", "2020", "1h 44m",
                "81%", "Animation, Drama, Romance, Fantasy",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/8Ga1CI4ZIIF8fxyfjZ5sNlb75e4.jpg",
                "Miyo \"Muge\" Sasaki is a peculiar second-year junior high student who has fallen in love with her classmate Kento Hinode. Muge resolutely pursues Kento every day, but he takes no notice of her. Nevertheless, while carrying a secret she can tell no one, Muge continues to pursue Kento. Muge discovers a magic mask that allows her to transform into a cat named Tarō. The magic lets Muge get close to Kento, but eventually it may also make her unable to transform back to a human.",
                false
        ))

        m.add(MovieEntity(
                "mv12", "Ip Man 4: The Finale ", "2019", "1h 45m",
                "72%", "Action, Drama, History",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/b5cz6BoyHrgBnhfDHOW5hXRWbln.jpg",
                "Following the death of his wife, Ip Man travels to San Francisco to ease tensions between the local kung fu masters and his star student, Bruce Lee, while searching for a better future for his son.",
                false
        ))

        m.add(MovieEntity(
                "mv13", "Weathering with You", "2019", "1h 52m",
                "82%", "Animation, Romance, Fantasy, Drama",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/qgrk7r1fV4IjuoeiGS5HOhXNdLJ.jpg",
                "Tokyo is currently experiencing rain showers that seem to disrupt the usual pace of everyone living there to no end. Amidst this seemingly eternal downpour arrives the runaway high school student Hodaka Morishima, who struggles to financially support himself—ending up with a job at a small-time publisher. At the same time, the orphaned Hina Amano also strives to find work to sustain herself and her younger brother. Both fates intertwine when Hodaka attempts to rescue Hina from shady men, deciding to run away together. Subsequently, Hodaka discovers that Hina has a strange yet astounding power: the ability to call out the sun whenever she prays for it. With Tokyo's unusual weather in mind, Hodaka sees the potential of this ability. He suggests that Hina should become a \"sunshine girl\"—someone who will clear the sky for people when they need it the most. Things begin looking up for them at first. However, it is common knowledge that power always comes with a hefty price...",
                false
        ))

        return m
    }

    fun generateTv(): List<MovieEntity> {

        val tv = ArrayList<MovieEntity>()

        tv.add(MovieEntity(
                "tv0", "The Mandalorian ", "2019", "35m",
                "85%", "Sci-Fi & Fantasy, Action & Adventure",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/sWgBv7LV2PRoQgkxwlibdGXKz1S.jpg",
                "After the fall of the Galactic Empire, lawlessness has spread throughout the galaxy. A lone gunfighter makes his way through the outer reaches, earning his keep as a bounty hunter.",
                false
        ))

        tv.add(MovieEntity(
                "tv1", "SEAL Team ", "2017", "43m",
                "78%", "Action & Adventure, Drama, War & Politics",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/uTSLeQTeHevt4fplegmQ6bOnE0Z.jpg",
                "The lives of the elite Navy Seals as they train, plan and execute the most dangerous, high-stakes missions our country can as",
                false
        ))

        tv.add(MovieEntity(
                "tv2", "Game of Thrones ", "2011", "1h",
                "84%", "Sci-Fi & Fantasy, Drama, Action & Adventure, Mystery",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                false
        ))

        tv.add(MovieEntity(
                "tv3", "The Simpsons", "1989", "22m",
                "78%", "Animation, Comedy, Family, Drama",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/2IWouZK4gkgHhJa3oyYuSWfSqbG.jpg",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                false
        ))

        tv.add(MovieEntity(
                "tv4", "Tokyo Ghoul", "2014", "24m",
                "85%", "Action & Adventure, Animation, Drama, Mystery",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/mt6ForyKh4JS0v5ho8xhauISidF.jpg",
                "Ken Kaneki is a bookworm college student who meets a girl names Rize at a cafe he frequents. They're the same age and have the same interests, so they quickly become close. Little does Kaneki know that Rize is a ghoul - a kind of monster that lives by hunting and devouring human flesh. When part of her special organ - \"the red child\" - is transplanted into Kaneki, he becomes a ghoul himself, trapped in a warped world where humans are not the top of the food chain.",
                false
        ))

        tv.add(MovieEntity(
                "tv5", "One-Punch Man", "2015", "24m",
                "84%", "Action & Adventure, Animation, Comedy",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/iE3s0lG5QVdEHOEZnoAxjmMtvne.jpg",
                "Saitama is a hero who only became a hero for fun. After three years of “special” training, though, he’s become so strong that he’s practically invincible. In fact, he’s too strong—even his mightiest opponents are taken out with a single punch, and it turns out that being devastatingly powerful is actually kind of a bore. With his passion for being a hero lost along with his hair, yet still faced with new enemies every day, how much longer can he keep it going?",
                false
        ))

        tv.add(MovieEntity(
                "tv6", "The God of High School ", "2020", "24m",
                "86%", "Animation, Comedy, Action & Adventure, Sci-Fi & Fantasy",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/AnXFYG7y2A65dr5noYvZSdVq8l3.jpg",
                "When an island half-disappears from the face of the earth, a mysterious organization sends out invitations for a tournament to every skilled fighter in the world. \"If you win you can have ANYTHING you want,\" they claim. They're recruiting only the best to fight the best and claim the title of The God of High School. Jin Mori, a Taekwondo specialist and a high school student, soon learns that there is something much greater beneath the stage of the tournament.",
                false
        ))

        tv.add(MovieEntity(
                "tv7", "The Rising of the Shield Hero", "2019", "24m",
                "91%", "Animation, Action & Adventure, Sci-Fi & Fantasy, Drama",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/ftavpq2PJn5pyo5opJEmj8QleKD.jpg",
                "Iwatani Naofumi was summoned into a parallel world along with 3 other people to become the world's Heroes. Each of the heroes respectively equipped with their own legendary equipment when summoned, Naofumi received the Legendary Shield as his weapon. Due to Naofumi's lack of charisma and experience he's labeled as the weakest, only to end up betrayed, falsely accused, and robbed by on the third day of adventure. Shunned by everyone from the king to peasants, Naofumi's thoughts were filled with nothing but vengeance and hatred. Thus, his destiny in a parallel World begins...",
                false
        ))

        tv.add(MovieEntity(
                "tv8", "Made In Abyss", "2017", "24m",
                "90%", "Action & Adventure, Animation, Sci-Fi & Fantasy",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/uVK3H8CgtrVgySFpdImvNXkN7RK.jpg",
                "The “Abyss” is the last unexplored region, an enormous and treacherous cave system filled with ancient relics and strange creatures. Only the bravest of adventurers can traverse its depths, earning them the nickname, “Cave Raiders.” Within the depths of the Abyss, a girl named Riko stumbles upon a robot who looks like a young boy. Tantalized by the Abyss, Riko and her new friend descend into uncharted territory to unlock its mysteries, but what lies in wait for them in the darkness?",
                false
        ))

        tv.add(MovieEntity(
                "tv9", "Attack on Titan: No Regrets", "2014", "27m",
                "89%", "Sci-Fi & Fantasy, Action & Adventure, Animation",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xGdz67d5WHIU7kIqVHO2TxIpmhZ.jpg",
                "Many years before becoming the famed captain of the Survey Corps, a young Levi struggles to survive in the capital's garbage dump, the Underground. As the boss of his own criminal operation, Levi attempts to get by with meager earnings while aided by fellow criminals, Isabel Magnolia and Farlan Church. With little hope for the future, Levi accepts a deal from the anti-expedition faction leader Nicholas Lobov, who promises the trio citizenship aboveground if they are able to successfully assassinate Erwin Smith, a squad leader of the Survey Corps.\n\nAs Levi and Erwin cross paths, Erwin acknowledges Levi's agility and skill and gives him the option to either become part of the expedition team, or be turned over to the Military Police, to atone for his crimes. Now closer to the man they are tasked to kill, the group plans to complete their mission and save themselves from a grim demise in the dim recesses of their past home. However, they are about to learn that the surface world is not as liberating as they had thought and that sometimes, freedom can come at a heavy price.\n\nBased on the popular spin-off manga of the same name, Attack on Titan: No Regrets illustrates the encounter between two of Attack on Titan's pivotal characters, as well as the events of the 23rd expedition beyond the walls.",
                false
        ))

        tv.add(MovieEntity(
                "tv10", "The Promised Neverland", "2019", "23m",
                "92%", "Animation, Mystery, Sci-Fi & Fantasy, Action & Adventure, Drama",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/yxdeII5tI8qqiERcMxjW9DfB6Gz.jpg",
                "Surrounded by a forest and a gated entrance, the Grace Field House is inhabited by orphans happily living together as one big family, looked after by their \"Mama,\" Isabella. Although they are required to take tests daily, the children are free to spend their time as they see fit, usually playing outside, as long as they do not venture too far from the orphanage — a rule they are expected to follow no matter what. However, all good times must come to an end, as every few months, a child is adopted and sent to live with their new family... never to be heard from again.\n\nHowever, the three oldest siblings have their suspicions about what is actually happening at the orphanage, and they are about to discover the cruel fate that awaits the children living at Grace Field, including the twisted nature of their beloved Mama.",
                false
        ))

        tv.add(MovieEntity(
                "tv11", "Under the Dome", "2013", "42m",
                "72%", "Drama, Mystery, Sci-Fi & Fantasy",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/fwH0ePhd7m3swtCuFeubtR49ZTd.jpg",
                "A small town is suddenly and inexplicably sealed off from the rest of the world by an enormous transparent dome. While military forces, the government and the media positioned outside of this surrounding barrier attempt to break it down, a small group of people inside attempt to figure out what the dome is, where it came from, and when (and if) it will go away.",
                false
        ))

        tv.add(MovieEntity(
                "tv12", "The Wilds", "2020", "1h",
                "84%", "Drama, Mystery",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/gHBtyMdHbWoM3tpM8VZymer8HfF.jpg",
                "A group of teen girls from different backgrounds must fight for survival after a plane crash strands them on a deserted island. The castaways both clash and bond as they learn more about each other, the secrets they keep, and the traumas they've all endured. But there’s just one twist… these girls did not end up on this island by accident.",
                false
        ))

        tv.add(MovieEntity(
                "tv13", "Chernobyl", "2019", "1h 10m",
                "85%", "Drama",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/hlLXt2tOPT6RRnjiUmoxyG1LTFi.jpg",
                "The true story of one of the worst man-made catastrophes in history: the catastrophic nuclear accident at Chernobyl. A tale of the brave men and women who sacrificed to save Europe from unimaginable disaster.",
                false
        ))

        return tv
    }

    fun generateRemoteDummyMovies(): ArrayList<MovieResponse>{

        val m = ArrayList<MovieResponse>()

        m.add(MovieResponse(
            "mv0", "Honset Thief", "2020", "1h 38m",
            "72%", "Action, Thriller, Crime, Drama",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/zeD4PabP6099gpE0STWJrJrCBCs.jpg",
            "A bank robber tries to turn himself in because he\'s falling in love and wants to live an honest life...but when he realizes the Feds are more corrupt than him, he must fight back to clear his name.",
            //false
        ))

        m.add(MovieResponse(
            "mv1", "Godmothered", "2020", "1h 53m",
            "72%", "Family, Fantasy, Comedy",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/ir8Qqi90mENhH7CDxEpdeCcm6UL.jpg",
            "A young and unskilled fairy godmother that ventures out on her own to prove her worth by tracking down a young girl whose request for help was ignored. What she discovers is that the girl has now become a grown woman in need of something very different than a \"prince charming.\"",
            //false
        ))

        m.add(MovieResponse(
            "mv2", "Wonder Woman 1984 ", "2020", "2h 31m",
            "78%", "Fantasy, Action, Adventure",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/di1bCAfGoJ0BzNEavLsPyxQ2AaB.jpg",
            "Wonder Woman comes into conflict with the Soviet Union during the Cold War in the 1980s and finds a formidable foe by the name of the Cheetah.",
            //false
        ))

        m.add(MovieResponse(
            "mv3", "Mulan", "2020", "1h 55m",
            "71%", "Action, Adventure, Drama, Fantasy",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/aKx1ARwG55zZ0GpRvU2WrGrCG9o.jpg",
            "When the Emperor of China issues a decree that one man per family must serve in the Imperial Chinese Army to defend the country from Huns, Hua Mulan, the eldest daughter of an honored warrior, steps in to take the place of her ailing father. She is spirited, determined and quick on her feet. Disguised as a man by the name of Hua Jun, she is tested every step of the way and must harness her innermost strength and embrace her true potential.",
            //false
        ))

        m.add(MovieResponse(
            "mv4", "Over the Moon ", "2020", "1h 40m",
            "76%", "Animation, Adventure, Family, Fantasy",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lQfdytwN7eh0tXWjIiMceFdBBvD.jpg",
            "In this animated musical, a girl builds a rocket ship and blasts off, hoping to meet a mythical moon goddess.",
            //false
        ))

        m.add(MovieResponse(
            "mv5", "Joker", "2019", "2h 2m",
            "82%", "Crime, Thriller, Drama",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg",
            "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",
            //false
        ))

        m.add(MovieResponse(
            "mv6", "Bad Boys for Life ", "2020", "2h 4m",
            "73%", "Thriller, Action, Crime",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/y95lQLnuNKdPAzw9F9Ab8kJ80c3.jpg",
            "Marcus and Mike are forced to confront new threats, career changes, and midlife crises as they join the newly created elite team AMMO of the Miami police department to take down the ruthless Armando Armas, the vicious leader of a Miami drug cartel.",
            //false
        ))

        m.add(MovieResponse(
            "mv7", "Mortal Kombat Legends: Scorpion's Revenge", "2020", "1h 20m",
            "84%", "Fantasy, Action, Adventure, Animation",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/4VlXER3FImHeFuUjBShFamhIp9M.jpg",
            "After the vicious slaughter of his family by stone-cold mercenary Sub-Zero, Hanzo Hasashi is exiled to the torturous Netherrealm. There, in exchange for his servitude to the sinister Quan Chi, he’s given a chance to avenge his family – and is resurrected as Scorpion, a lost soul bent on revenge. Back on Earthrealm, Lord Raiden gathers a team of elite warriors – Shaolin monk Liu Kang, Special Forces officer Sonya Blade and action star Johnny Cage – an unlikely band of heroes with one chance to save humanity. To do this, they must defeat Shang Tsung’s horde of Outworld gladiators and reign over the Mortal Kombat tournament.",
            //false
        ))

        m.add(MovieResponse(
            "mv8", "Alladin", "2019", "2h 8m",
            "72%", "Adventure, Fantasy, Romance, Family",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/ykUEbfpkf8d0w49pHh0AD2KrT52.jpg",
            "A kindhearted street urchin named Aladdin embarks on a magical adventure after finding a lamp that releases a wisecracking genie while a power-hungry Grand Vizier vies for the same lamp that has the power to make their deepest wishes come true.",
            //false
        ))

        m.add(MovieResponse(
            "mv9", "A Silent Voice", "2016", "2h 10m",
            "84%", "Animation, Drama, Romance",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/drlyoSKDOPnxzJFrRWGqzDsyJvR.jpg",
            "Shouya Ishida starts bullying the new girl in class, Shouko Nishimiya, because she is deaf. But as the teasing continues, the rest of the class starts to turn on Shouya for his lack of compassion. When they leave elementary school, Shouko and Shouya do not speak to each other again... until an older, wiser Shouya, tormented by his past behaviour, decides he must see Shouko once more. He wants to atone for his sins, but is it already too late...?",
            //false
        ))

        m.add(MovieResponse(
            "mv10", "Tenet ", "2020", "2h 30m",
            "74%", "Action, Thriller, Science Fiction",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/k68nPLbIST6NP96JmTxmZijEvCA.jpg",
            "Armed with only one word - Tenet - and fighting for the survival of the entire world, the Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.",
            //false
        ))

        m.add(MovieResponse(
            "mv11", "A Whisker Away ", "2020", "1h 44m",
            "81%", "Animation, Drama, Romance, Fantasy",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/8Ga1CI4ZIIF8fxyfjZ5sNlb75e4.jpg",
            "Miyo \"Muge\" Sasaki is a peculiar second-year junior high student who has fallen in love with her classmate Kento Hinode. Muge resolutely pursues Kento every day, but he takes no notice of her. Nevertheless, while carrying a secret she can tell no one, Muge continues to pursue Kento. Muge discovers a magic mask that allows her to transform into a cat named Tarō. The magic lets Muge get close to Kento, but eventually it may also make her unable to transform back to a human.",
            //false
        ))

        m.add(MovieResponse(
            "mv12", "Ip Man 4: The Finale ", "2019", "1h 45m",
            "72%", "Action, Drama, History",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/b5cz6BoyHrgBnhfDHOW5hXRWbln.jpg",
            "Following the death of his wife, Ip Man travels to San Francisco to ease tensions between the local kung fu masters and his star student, Bruce Lee, while searching for a better future for his son.",
            //false
        ))

        m.add(MovieResponse(
            "mv13", "Weathering with You", "2019", "1h 52m",
            "82%", "Animation, Romance, Fantasy, Drama",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/qgrk7r1fV4IjuoeiGS5HOhXNdLJ.jpg",
            "Tokyo is currently experiencing rain showers that seem to disrupt the usual pace of everyone living there to no end. Amidst this seemingly eternal downpour arrives the runaway high school student Hodaka Morishima, who struggles to financially support himself—ending up with a job at a small-time publisher. At the same time, the orphaned Hina Amano also strives to find work to sustain herself and her younger brother. Both fates intertwine when Hodaka attempts to rescue Hina from shady men, deciding to run away together. Subsequently, Hodaka discovers that Hina has a strange yet astounding power: the ability to call out the sun whenever she prays for it. With Tokyo's unusual weather in mind, Hodaka sees the potential of this ability. He suggests that Hina should become a \"sunshine girl\"—someone who will clear the sky for people when they need it the most. Things begin looking up for them at first. However, it is common knowledge that power always comes with a hefty price...",
            //false
        ))

        return m
    }

    fun generateRemoteDummyTv(): ArrayList<TvResponse> {

        val tv = ArrayList<TvResponse>()

        tv.add(TvResponse(
            "tv0", "The Mandalorian ", "2019", "35m",
            "85%", "Sci-Fi & Fantasy, Action & Adventure",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/sWgBv7LV2PRoQgkxwlibdGXKz1S.jpg",
            "After the fall of the Galactic Empire, lawlessness has spread throughout the galaxy. A lone gunfighter makes his way through the outer reaches, earning his keep as a bounty hunter.",
            //false
        ))

        tv.add(TvResponse(
            "tv1", "SEAL Team ", "2017", "43m",
            "78%", "Action & Adventure, Drama, War & Politics",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/uTSLeQTeHevt4fplegmQ6bOnE0Z.jpg",
            "The lives of the elite Navy Seals as they train, plan and execute the most dangerous, high-stakes missions our country can as",
            //false
        ))

        tv.add(TvResponse(
            "tv2", "Game of Thrones ", "2011", "1h",
            "84%", "Sci-Fi & Fantasy, Drama, Action & Adventure, Mystery",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
            "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
            //false
        ))

        tv.add(TvResponse(
            "tv3", "The Simpsons", "1989", "22m",
            "78%", "Animation, Comedy, Family, Drama",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/2IWouZK4gkgHhJa3oyYuSWfSqbG.jpg",
            "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
            //false
        ))

        tv.add(TvResponse(
            "tv4", "Tokyo Ghoul", "2014", "24m",
            "85%", "Action & Adventure, Animation, Drama, Mystery",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/mt6ForyKh4JS0v5ho8xhauISidF.jpg",
            "Ken Kaneki is a bookworm college student who meets a girl names Rize at a cafe he frequents. They're the same age and have the same interests, so they quickly become close. Little does Kaneki know that Rize is a ghoul - a kind of monster that lives by hunting and devouring human flesh. When part of her special organ - \"the red child\" - is transplanted into Kaneki, he becomes a ghoul himself, trapped in a warped world where humans are not the top of the food chain.",
            //false
        ))

        tv.add(TvResponse(
            "tv5", "One-Punch Man", "2015", "24m",
            "84%", "Action & Adventure, Animation, Comedy",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/iE3s0lG5QVdEHOEZnoAxjmMtvne.jpg",
            "Saitama is a hero who only became a hero for fun. After three years of “special” training, though, he’s become so strong that he’s practically invincible. In fact, he’s too strong—even his mightiest opponents are taken out with a single punch, and it turns out that being devastatingly powerful is actually kind of a bore. With his passion for being a hero lost along with his hair, yet still faced with new enemies every day, how much longer can he keep it going?",
            //false
        ))

        tv.add(TvResponse(
            "tv6", "The God of High School ", "2020", "24m",
            "86%", "Animation, Comedy, Action & Adventure, Sci-Fi & Fantasy",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/AnXFYG7y2A65dr5noYvZSdVq8l3.jpg",
            "When an island half-disappears from the face of the earth, a mysterious organization sends out invitations for a tournament to every skilled fighter in the world. \"If you win you can have ANYTHING you want,\" they claim. They're recruiting only the best to fight the best and claim the title of The God of High School. Jin Mori, a Taekwondo specialist and a high school student, soon learns that there is something much greater beneath the stage of the tournament.",
            //false
        ))

        tv.add(TvResponse(
            "tv7", "The Rising of the Shield Hero", "2019", "24m",
            "91%", "Animation, Action & Adventure, Sci-Fi & Fantasy, Drama",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/ftavpq2PJn5pyo5opJEmj8QleKD.jpg",
            "Iwatani Naofumi was summoned into a parallel world along with 3 other people to become the world's Heroes. Each of the heroes respectively equipped with their own legendary equipment when summoned, Naofumi received the Legendary Shield as his weapon. Due to Naofumi's lack of charisma and experience he's labeled as the weakest, only to end up betrayed, //falsely accused, and robbed by on the third day of adventure. Shunned by everyone from the king to peasants, Naofumi's thoughts were filled with nothing but vengeance and hatred. Thus, his destiny in a parallel World begins...",
            //false
        ))

        tv.add(TvResponse(
            "tv8", "Made In Abyss", "2017", "24m",
            "90%", "Action & Adventure, Animation, Sci-Fi & Fantasy",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/uVK3H8CgtrVgySFpdImvNXkN7RK.jpg",
            "The “Abyss” is the last unexplored region, an enormous and treacherous cave system filled with ancient relics and strange creatures. Only the bravest of adventurers can traverse its depths, earning them the nickname, “Cave Raiders.” Within the depths of the Abyss, a girl named Riko stumbles upon a robot who looks like a young boy. Tantalized by the Abyss, Riko and her new friend descend into uncharted territory to unlock its mysteries, but what lies in wait for them in the darkness?",
            //false
        ))

        tv.add(TvResponse(
            "tv9", "Attack on Titan: No Regrets", "2014", "27m",
            "89%", "Sci-Fi & Fantasy, Action & Adventure, Animation",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xGdz67d5WHIU7kIqVHO2TxIpmhZ.jpg",
            "Many years before becoming the famed captain of the Survey Corps, a young Levi struggles to survive in the capital's garbage dump, the Underground. As the boss of his own criminal operation, Levi attempts to get by with meager earnings while aided by fellow criminals, Isabel Magnolia and Farlan Church. With little hope for the future, Levi accepts a deal from the anti-expedition faction leader Nicholas Lobov, who promises the trio citizenship aboveground if they are able to successfully assassinate Erwin Smith, a squad leader of the Survey Corps.\n\nAs Levi and Erwin cross paths, Erwin acknowledges Levi's agility and skill and gives him the option to either become part of the expedition team, or be turned over to the Military Police, to atone for his crimes. Now closer to the man they are tasked to kill, the group plans to complete their mission and save themselves from a grim demise in the dim recesses of their past home. However, they are about to learn that the surface world is not as liberating as they had thought and that sometimes, freedom can come at a heavy price.\n\nBased on the popular spin-off manga of the same name, Attack on Titan: No Regrets illustrates the encounter between two of Attack on Titan's pivotal characters, as well as the events of the 23rd expedition beyond the walls.",
            //false
        ))

        tv.add(TvResponse(
            "tv10", "The Promised Neverland", "2019", "23m",
            "92%", "Animation, Mystery, Sci-Fi & Fantasy, Action & Adventure, Drama",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/yxdeII5tI8qqiERcMxjW9DfB6Gz.jpg",
            "Surrounded by a forest and a gated entrance, the Grace Field House is inhabited by orphans happily living together as one big family, looked after by their \"Mama,\" Isabella. Although they are required to take tests daily, the children are free to spend their time as they see fit, usually playing outside, as long as they do not venture too far from the orphanage — a rule they are expected to follow no matter what. However, all good times must come to an end, as every few months, a child is adopted and sent to live with their new family... never to be heard from again.\n\nHowever, the three oldest siblings have their suspicions about what is actually happening at the orphanage, and they are about to discover the cruel fate that awaits the children living at Grace Field, including the twisted nature of their beloved Mama.",
            //false
        ))

        tv.add(TvResponse(
            "tv11", "Under the Dome", "2013", "42m",
            "72%", "Drama, Mystery, Sci-Fi & Fantasy",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/fwH0ePhd7m3swtCuFeubtR49ZTd.jpg",
            "A small town is suddenly and inexplicably sealed off from the rest of the world by an enormous transparent dome. While military forces, the government and the media positioned outside of this surrounding barrier attempt to break it down, a small group of people inside attempt to figure out what the dome is, where it came from, and when (and if) it will go away.",
            //false
        ))

        tv.add(TvResponse(
            "tv12", "The Wilds", "2020", "1h",
            "84%", "Drama, Mystery",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/gHBtyMdHbWoM3tpM8VZymer8HfF.jpg",
            "A group of teen girls from different backgrounds must fight for survival after a plane crash strands them on a deserted island. The castaways both clash and bond as they learn more about each other, the secrets they keep, and the traumas they've all endured. But there’s just one twist… these girls did not end up on this island by accident.",
            //false
        ))

        tv.add(TvResponse(
            "tv13", "Chernobyl", "2019", "1h 10m",
            "85%", "Drama",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/hlLXt2tOPT6RRnjiUmoxyG1LTFi.jpg",
            "The true story of one of the worst man-made catastrophes in history: the catastrophic nuclear accident at Chernobyl. A tale of the brave men and women who sacrificed to save Europe from unimaginable disaster.",
            //false
        ))

        return tv
    }

}