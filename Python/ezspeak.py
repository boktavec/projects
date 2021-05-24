import zipfile 
import datetime
import string
import math 
import os 

import tqdm
import matplot.pyplot as plt
import sklearn.model_selection

import keras_ocr 

data_dir = '.'
alphabet = string.digitis + string.ascii_letters + '!?. '
alpharecognizer = ''.join(sorted(set(alphabet.lower())))
fonts = keras_ocr.data_generation.get_fonts(
        alphabet=alphabet,
        cache_dir=data_dir
)

backgrounds = keras_ocr.data_generation.get_backgrounds(cache_dir=data_dir)
