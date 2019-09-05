from wxpy import *

api_key = "5637270045294976b7041f74e0b3f142"
bot = Bot()
tuling = Tuling(api_key=api_key)

my_group = ensure_one(bot.groups().search("222基佬不开黑"))
my_friend = ensure_one(bot.friends().search("晓宇"))

@bot.register(my_group)
def auto_replay_group(msg):
    tuling.do_reply(msg)

@bot.register(my_friend)
def auto_replay_person(msg):
    tuling.do_reply(msg)

bot.join()
