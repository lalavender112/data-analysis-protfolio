#agg_table
agg_table <- astronauts_cleaning %>% group_by(Profile.Gender) %>% summarise(mean_brith_year = mean(`Profile.Birth Year`, na.rm = TRUE), count_people = n())

# agg_table2
agg_table2 <- astronauts_cleaning %>% group_by(Profile.Gender, Profile.Nationality) %>% summarise(mean_brith_year = mean(`Profile.Birth Year`, na.rm = TRUE), count_people = n())
