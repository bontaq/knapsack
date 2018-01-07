module Main where

import           Data.List.Split

type Capacity = Int
type NumberItems = Int
data Bag = Bag Capacity NumberItems
          deriving (Show)

type Weight = Int
type Value = Int
data Item = Item Weight Value
          deriving (Show)

badSolver' :: Item -> [Int] -> [Int]
badSolver' = undefined

badSolver :: Bag -> [Item] -> [Int]
badSolver bag items = foldr badSolver' [] items

main :: IO ()
main = do
  f <- readFile "../data/ks_4_0"
  let ls           = lines f
      parsedLines  = map (map (\c -> read c :: Int) . splitOn " ") ls

      (spec:items) = parsedLines
      spec' = Bag (spec !! 0) (spec !! 1)
      items' = map (\[weight, value] -> Item weight value) items

  putStrLn $ show items'
